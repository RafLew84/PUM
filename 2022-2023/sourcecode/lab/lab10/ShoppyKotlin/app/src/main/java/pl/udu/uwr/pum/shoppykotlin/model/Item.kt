package pl.udu.uwr.pum.shoppykotlin.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class Item (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val quantity: Int
)