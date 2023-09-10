package com.example.retrofitbasicskotlin.data.repository

import com.example.retrofitbasicskotlin.data.Post
import com.example.retrofitbasicskotlin.data.api.RetrofitInstance

class PostRepository {
    private val api = RetrofitInstance.api

    suspend fun getPosts(): List<Post>{
        return api.posts()
    }
}