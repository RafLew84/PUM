package pl.udu.uwr.pum.retrofitpostbasicskotlin

import com.google.gson.annotations.SerializedName

data class Post (
    val userId: Int,
    val title: String,

    @SerializedName("body")
    val content: String
){
    var id: Int? = null
}
