package com.example.retrofitbasicscompose.data.repository

import com.example.retrofitbasicscompose.api.RetrofitInstance
import com.example.retrofitbasicscompose.data.Post
import com.example.retrofitbasicscompose.data.PostResponse

class PostRepository {
    private val api = RetrofitInstance.api

    suspend fun getPosts(): List<Post>{
        return api.posts()
    }
}