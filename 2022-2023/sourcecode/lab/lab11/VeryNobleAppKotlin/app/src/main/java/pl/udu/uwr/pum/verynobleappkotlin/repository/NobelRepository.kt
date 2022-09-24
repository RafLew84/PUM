package pl.udu.uwr.pum.verynobleappkotlin.repository

import pl.udu.uwr.pum.verynobleappkotlin.api.RetrofitInstance

class NobelRepository {
    suspend fun getNobelPrizes(category: String) = RetrofitInstance.api.getNobelPrizes(category=category)
    suspend fun getNobelPrize(year: Int, category: String) = RetrofitInstance.api.getNobelPrize(year = year, category = category)
}