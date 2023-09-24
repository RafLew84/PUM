package com.example.resourcepatterinbasicscompose.api

import com.example.resourcepatterinbasicscompose.data.CommentResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface PlaceholderApi {
    @GET("comments")
    suspend fun comments(): Response<List<CommentResponseItem>>
}