package com.example.resourcepatternbasicskotlin.data.api

import com.example.resourcepatternbasicskotlin.data.CommentResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface PlaceholderApi {
    @GET("comments")
    suspend fun comments(): Response<List<CommentResponseItem>>
}