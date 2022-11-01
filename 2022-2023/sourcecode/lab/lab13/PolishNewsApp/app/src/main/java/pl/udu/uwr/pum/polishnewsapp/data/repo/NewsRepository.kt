package pl.udu.uwr.pum.polishnewsapp.data.repo

import androidx.room.withTransaction
import kotlinx.coroutines.flow.Flow
import pl.udu.uwr.pum.polishnewsapp.data.api.NewsApi
import pl.udu.uwr.pum.polishnewsapp.data.db.ArticlesDatabase
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.LatestNews
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.NewsArticle
import pl.udu.uwr.pum.polishnewsapp.util.Resource
import pl.udu.uwr.pum.polishnewsapp.util.networkBoundResource
import javax.inject.Inject

class NewsRepository @Inject constructor (
    private val api: NewsApi,
    private val db: ArticlesDatabase
) {
    private val dao = db.articleDao()

    fun getLatestNews(): Flow<Resource<List<NewsArticle>>> = networkBoundResource(
        query = {dao.getAllLatestNewsArticles()},
        fetch = {
            val response = api.getLatestNews()
            response.results
        },
        saveFetchResult = { articles ->
            val news = articles.map { article ->
                NewsArticle(
                    title = article.title,
                    url = article.link,
                    imageUrl = article.image_url,
                    isFavorite = false,
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
        }
    )
}