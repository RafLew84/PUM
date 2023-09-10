package com.example.retrofitbasicskotlin.data

import com.google.gson.annotations.SerializedName
data class Post (
    val userId: Int,
    val id: Int,
    val title: String,

    @SerializedName("body")
    val content: String
)