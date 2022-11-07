package pl.udu.uwr.pum.polishnewsapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.LatestNews
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.NewsArticle

@Dao
interface ArticleDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertArticles(articles: List<NewsArticle>)

    @Insert(onConflict = REPLACE)
    suspend fun insertLatestNews(latestNews: List<LatestNews>)

    @Update
    suspend fun updateArticle(newsArticle: NewsArticle)

    @Query("SELECT * FROM latest_news INNER JOIN articles ON articleUrl = url")
    fun getAllLatestNewsArticles(): Flow<List<NewsArticle>>

    @Query("DELETE FROM latest_news")
    suspend fun delete()

    @Query("DELETE FROM articles WHERE lastUpdate < :timeStampInMillis AND isFavorite = 0")
    suspend fun deleteNotFavoriteOlderThan(timeStampInMillis: Long)

    @Query("SELECT * FROM articles WHERE isFavorite = 1")
    fun getAllFavorite(): Flow<List<NewsArticle>>
}