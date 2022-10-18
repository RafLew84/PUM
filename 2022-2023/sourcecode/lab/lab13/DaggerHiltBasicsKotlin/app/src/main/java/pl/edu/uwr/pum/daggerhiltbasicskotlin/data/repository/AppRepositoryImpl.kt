package pl.edu.uwr.pum.daggerhiltbasicskotlin.data.repository

import pl.edu.uwr.pum.daggerhiltbasicskotlin.data.Post
import pl.edu.uwr.pum.daggerhiltbasicskotlin.data.remote.PlaceholderApi
import pl.edu.uwr.pum.daggerhiltbasicskotlin.domain.remote.AppRepository
import retrofit2.Response

class AppRepositoryImpl(
    private val api: PlaceholderApi
) : AppRepository {
    override suspend fun getPosts() = api.posts()
}