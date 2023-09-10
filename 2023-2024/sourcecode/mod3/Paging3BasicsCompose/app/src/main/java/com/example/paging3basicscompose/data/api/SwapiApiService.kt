package com.example.paging3basicscompose.data.api

import com.example.paging3basicscompose.data.model.SwapiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SwapiApiService {
    @GET("people")
    suspend fun getCharacters(
        @Query("page") page: Int
    ): SwapiResponse
}