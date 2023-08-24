package com.example.paging3roombasicscompose.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paging3roombasicscompose.data.db.Item
import com.example.paging3roombasicscompose.data.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ItemViewModel(application: Application) : ViewModel() {
    private val repository = ItemRepository(application)
    val items: Flow<PagingData<Item>> = repository.getItems().cachedIn(viewModelScope)

    init {
        val sampleItems = List(100) { Item(it, "Item $it") }
        insert(sampleItems)
    }

    private fun insert(items: List<Item>){
        viewModelScope.launch {
            repository.insertItems(items)
        }
    }
}