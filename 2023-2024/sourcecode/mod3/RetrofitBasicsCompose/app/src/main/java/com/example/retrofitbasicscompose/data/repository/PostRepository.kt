package com.example.retrofitbasicscompose.data.repository

import com.example.retrofitbasicscompose.api.RetrofitInstance
import com.example.retrofitbasicscompose.data.Post

class PostRepository {
    private val api = RetrofitInstance.api

    suspend fun getPosts(): List<Post>{
        return api.posts()
    }
}