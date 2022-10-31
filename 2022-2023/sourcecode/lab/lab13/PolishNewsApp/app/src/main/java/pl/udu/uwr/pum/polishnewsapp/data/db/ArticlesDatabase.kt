package pl.udu.uwr.pum.polishnewsapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.LatestNews
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.NewsArticle

@Database(entities = [NewsArticle::class, LatestNews::class], version = 1, exportSchema = false)
abstract class ArticlesDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao
}