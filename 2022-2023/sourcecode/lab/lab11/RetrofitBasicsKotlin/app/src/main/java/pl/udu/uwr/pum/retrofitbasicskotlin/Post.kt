package pl.udu.uwr.pum.retrofitbasicskotlin

import com.google.gson.annotations.SerializedName

data class Post (
    val userId: Int,
    val id: Int,
    val title: String,

    @SerializedName("body")
    val content: String
)
