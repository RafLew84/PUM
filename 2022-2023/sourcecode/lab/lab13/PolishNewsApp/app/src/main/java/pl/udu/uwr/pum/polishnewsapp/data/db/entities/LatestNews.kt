package pl.udu.uwr.pum.polishnewsapp.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "latest_news")
data class LatestNews (
    val articleUrl: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)