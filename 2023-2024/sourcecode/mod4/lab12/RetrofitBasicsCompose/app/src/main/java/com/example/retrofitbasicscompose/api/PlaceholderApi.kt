package com.example.retrofitbasicscompose.api

import com.example.retrofitbasicscompose.data.Post
import retrofit2.http.GET

interface PlaceholderApi {
    @GET("posts")
    suspend fun posts(): List<Post>
}