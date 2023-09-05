package com.example.paging3basicscompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paging3basicscompose.data.api.RetrofitInstance
import com.example.paging3basicscompose.data.model.Result
import com.example.paging3basicscompose.data.repository.SwapiRepository
import com.example.paging3basicscompose.ui.screens.list.CharactersPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SwapiViewModel : ViewModel() {
    private val repository = SwapiRepository()

    fun getData() = Pager(
        config = PagingConfig(
            pageSize = 10,
        ),
        pagingSourceFactory = {
            CharactersPagingSource(repository)
        }
    ).flow
}