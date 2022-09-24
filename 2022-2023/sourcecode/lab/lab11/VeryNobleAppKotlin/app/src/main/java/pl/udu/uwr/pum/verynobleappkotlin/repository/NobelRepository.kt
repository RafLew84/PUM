package pl.udu.uwr.pum.verynobleappkotlin.repository

import pl.udu.uwr.pum.verynobleappkotlin.api.RetrofitInstance

class NobelRepository {
    suspend fun getNobelPrizes(category: String) = RetrofitInstance.api.getNobelPrizes(category=category)
}