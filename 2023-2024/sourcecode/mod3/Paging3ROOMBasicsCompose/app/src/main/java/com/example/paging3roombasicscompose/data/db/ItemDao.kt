package com.example.paging3roombasicscompose.data.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ItemDao {
    @Query("SELECT * FROM items")
    fun getItems(): PagingSource<Int, Item>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItems(items: List<Item>)
}