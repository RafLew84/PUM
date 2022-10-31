package pl.udu.uwr.pum.polishnewsapp.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class NewsArticle (
    val description: String?,
    val imageUrl: String?,
    @PrimaryKey val url: String,
    val title: String?,
    val isFavorite: Boolean
)