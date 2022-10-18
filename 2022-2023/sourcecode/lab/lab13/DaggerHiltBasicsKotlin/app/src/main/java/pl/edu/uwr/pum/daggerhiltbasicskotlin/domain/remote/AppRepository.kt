package pl.edu.uwr.pum.daggerhiltbasicskotlin.domain.remote

import pl.edu.uwr.pum.daggerhiltbasicskotlin.data.Post
import retrofit2.Response

interface AppRepository {
    suspend fun getPosts(): Response<List<Post>>
}