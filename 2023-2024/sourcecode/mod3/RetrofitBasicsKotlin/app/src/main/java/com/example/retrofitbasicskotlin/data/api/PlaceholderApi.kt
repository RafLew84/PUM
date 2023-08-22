package com.example.retrofitbasicskotlin.data.api

import com.example.retrofitbasicskotlin.data.Post
import retrofit2.http.GET

interface PlaceholderApi {
    @GET("posts")
    suspend fun posts(): List<Post>
}