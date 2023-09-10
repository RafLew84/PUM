package com.example.paging3basicskotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.paging3basicskotlin.data.repository.CharactersPagingSource
import com.example.paging3basicskotlin.data.repository.SwapiRepository

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