package pl.udu.uwr.pum.offlinecachingbasicskotlin.data.remote

import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.User
import retrofit2.Response
import retrofit2.http.GET

interface RandomApi {
    @GET("users?size=20")
    suspend fun users(): List<User>
}