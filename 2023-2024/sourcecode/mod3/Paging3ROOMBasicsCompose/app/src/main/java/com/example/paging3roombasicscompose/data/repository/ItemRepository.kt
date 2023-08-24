package com.example.paging3roombasicscompose.data.repository

import android.app.Application
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.paging3roombasicscompose.data.db.Item
import com.example.paging3roombasicscompose.data.db.ItemDatabase
import kotlinx.coroutines.flow.Flow

class ItemRepository(application: Application) {
    private val db = ItemDatabase.getDatabase(application)
    private val dao = db.itemDao()
    fun getItems(): Flow<PagingData<Item>> {
        return Pager(config = PagingConfig(pageSize = 20)) {
            dao.getItems()
        }.flow
    }

    suspend fun insertItems(items: List<Item>){
        dao.insertItems(items)
    }
}