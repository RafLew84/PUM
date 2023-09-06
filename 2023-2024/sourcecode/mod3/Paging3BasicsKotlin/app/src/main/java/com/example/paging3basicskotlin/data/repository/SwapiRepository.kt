package com.example.paging3basicskotlin.data.repository

import com.example.paging3basicskotlin.data.api.RetrofitInstance


class SwapiRepository {
    private val api = RetrofitInstance.api

    suspend fun getCharacters(page: Int) = api.getCharacters(page)
}