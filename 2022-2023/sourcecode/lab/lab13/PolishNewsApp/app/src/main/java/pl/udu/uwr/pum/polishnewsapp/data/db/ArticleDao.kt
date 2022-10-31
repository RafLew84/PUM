package pl.udu.uwr.pum.polishnewsapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.LatestNews
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.NewsArticle

@Dao
interface ArticleDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertArticles(articles: List<NewsArticle>)

    @Insert(onConflict = REPLACE)
    suspend fun insertLatestArticles(latestArticles: List<LatestNews>)

    @Query("SELECT * FROM latest_news INNER JOIN articles ON articleUrl = url")
    fun getAllLatestNewsArticles(): Flow<List<NewsArticle>>

    @Query("DELETE FROM latest_news")
    suspend fun delete()
}