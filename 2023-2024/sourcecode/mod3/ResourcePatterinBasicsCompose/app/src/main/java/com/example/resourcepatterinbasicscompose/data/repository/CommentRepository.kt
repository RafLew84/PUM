package com.example.resourcepatterinbasicscompose.data.repository

import com.example.resourcepatterinbasicscompose.api.RetrofitInstance


class CommentRepository {
    private val api = RetrofitInstance.api

    suspend fun getComments() = api.comments()
}