package com.example.paging3basicscompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.paging3basicscompose.data.repository.SwapiRepository
import com.example.paging3basicscompose.data.repository.CharactersPagingSource

class SwapiViewModel : ViewModel() {
    private val repository = SwapiRepository()

    fun getData() = Pager(
        config = PagingConfig(
            pageSize = 10,
        ),
        pagingSourceFactory = {
            CharactersPagingSource(repository)
        }
    ).flow.cachedIn(viewModelScope)
}