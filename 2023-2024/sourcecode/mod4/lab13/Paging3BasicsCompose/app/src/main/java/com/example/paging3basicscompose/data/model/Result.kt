package com.example.paging3basicscompose.data.model

import com.google.gson.annotations.SerializedName

data class Result(
    val height: String,
    @SerializedName("homeworld") val homeWorld: String,
    val name: String,
)