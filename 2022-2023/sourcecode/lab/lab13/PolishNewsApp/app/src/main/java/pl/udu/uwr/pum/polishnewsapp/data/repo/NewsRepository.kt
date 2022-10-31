package pl.udu.uwr.pum.polishnewsapp.data.repo

import pl.udu.uwr.pum.polishnewsapp.data.api.NewsApi
import pl.udu.uwr.pum.polishnewsapp.data.db.ArticlesDatabase
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.NewsArticle
import javax.inject.Inject

class NewsRepository @Inject constructor (
    private val api: NewsApi,
    //private val db: ArticlesDatabase
) {
    //private val dao = db.articleDao()

    suspend fun getLatestNews(): List<NewsArticle>{
        val response = api.getLatestNews()
        return response.results.map {
            NewsArticle(
                title = it.title,
                url = it.link,
                imageUrl = it.image_url,
                description = it.description,
                isFavorite = false
            )
        }
    }
}