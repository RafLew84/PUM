package pl.edu.uwr.pum.daggerhiltbasicskotlin.data.remote

import pl.edu.uwr.pum.daggerhiltbasicskotlin.data.Post
import retrofit2.Response
import retrofit2.http.GET

interface PlaceholderApi {
    @GET("posts")
    suspend fun posts(): Response<List<Post>>
}