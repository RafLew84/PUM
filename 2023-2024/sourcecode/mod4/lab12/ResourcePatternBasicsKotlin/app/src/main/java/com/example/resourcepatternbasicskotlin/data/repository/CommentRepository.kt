package com.example.resourcepatternbasicskotlin.data.repository

import com.example.resourcepatternbasicskotlin.data.api.RetrofitInstance


class CommentRepository {
    private val api = RetrofitInstance.api

    suspend fun getComments() = api.comments()
}