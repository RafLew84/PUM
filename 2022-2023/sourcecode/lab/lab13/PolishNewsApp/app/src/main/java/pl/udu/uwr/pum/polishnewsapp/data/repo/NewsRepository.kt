package pl.udu.uwr.pum.polishnewsapp.data.repo

import androidx.room.withTransaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import okio.IOException
import pl.udu.uwr.pum.polishnewsapp.data.api.NewsApi
import pl.udu.uwr.pum.polishnewsapp.data.db.ArticlesDatabase
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.LatestNews
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.NewsArticle
import pl.udu.uwr.pum.polishnewsapp.util.Resource
import pl.udu.uwr.pum.polishnewsapp.util.TIME_TO_REFRESH_DATA
import pl.udu.uwr.pum.polishnewsapp.util.networkBoundResource
import retrofit2.HttpException
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.random.Random

class NewsRepository @Inject constructor (
    private val api: NewsApi,
    private val db: ArticlesDatabase
) {
    private val dao = db.articleDao()

    fun getLatestNews(
        requestRefresh: Boolean,
        fetchFail: (Throwable) -> Unit,
        fetchSuccess: () -> Unit): Flow<Resource<List<NewsArticle>>> = networkBoundResource(
        query = {dao.getAllLatestNewsArticles()},
        fetch = {
            val response = api.getLatestNews(Random.nextInt(1, 40))
            response.results
        },
        saveFetchResult = { articles ->
            val favoriteArticles = dao.getAllFavorite().first()
            val news = articles.map { article ->
                val isFavorite = favoriteArticles.any { it.url == article.link }
                NewsArticle(
                    title = article.title,
                    url = article.link,
                    imageUrl = article.image_url,
                    isFavorite = isFavorite,
                    description = article.description
                )
            }

            val latest = news.map { article ->
                LatestNews(article.url)
            }

            db.withTransaction {
                dao.apply {
                    delete()
                    insertArticles(news)
                    insertLatestArticles(latest)
                }
            }
        },
        fetchFailed = { t ->
            if (t !is HttpException && t !is IOException)
                throw t
            fetchFail(t)
        },
        fetchSuccess = fetchSuccess,
        shouldFetch = { cached ->
            if (requestRefresh) true else {
            val oldestTimeStamp = cached.minByOrNull { article -> article.lastUpdate }?.lastUpdate
            oldestTimeStamp == null || oldestTimeStamp < System.currentTimeMillis() - TIME_TO_REFRESH_DATA
            }
        }
    )

    suspend fun deleteNonFavoriteArticlesOlderThan(timeStampInMillis: Long){
        dao.deleteNotFavoriteOlderThan(timeStampInMillis)
    }

    suspend fun updateArticle(newsArticle: NewsArticle){
        dao.updateArticle(newsArticle)
    }

    fun getAllFavoriteArticles(): Flow<List<NewsArticle>> = dao.getAllFavorite()
}