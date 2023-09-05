package com.example.paging3basicscompose.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.paging3basicscompose.data.api.RetrofitInstance
import com.example.paging3basicscompose.ui.screens.list.CharactersPagingSource

class SwapiRepository {
    private val api = RetrofitInstance.api

    suspend fun getCharacters(page: Int) = api.getCharacters(page)
}