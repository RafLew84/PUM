package pl.edu.uwr.pum.daggerhiltbasicskotlin.data.repository

import pl.edu.uwr.pum.daggerhiltbasicskotlin.data.remote.PlaceholderApi
import javax.inject.Inject

class AppRepository @Inject constructor (
    private val api: PlaceholderApi
) {
    suspend fun getPosts() = api.posts()
}