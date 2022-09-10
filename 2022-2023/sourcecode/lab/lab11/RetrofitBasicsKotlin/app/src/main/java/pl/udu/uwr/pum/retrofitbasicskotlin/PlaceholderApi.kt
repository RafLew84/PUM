package pl.udu.uwr.pum.retrofitbasicskotlin

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface PlaceholderApi {
    @GET("posts")
    fun posts(): Call<List<Post>>
}