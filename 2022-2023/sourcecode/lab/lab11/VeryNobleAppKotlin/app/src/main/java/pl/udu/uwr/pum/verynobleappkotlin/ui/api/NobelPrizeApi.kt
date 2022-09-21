package pl.udu.uwr.pum.verynobleappkotlin.ui.api

import pl.udu.uwr.pum.verynobleappkotlin.ui.data.NobelPrizeResponse
import pl.udu.uwr.pum.verynobleappkotlin.ui.util.Cat
import pl.udu.uwr.pum.verynobleappkotlin.ui.util.categories
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface NobelPrizeApi {
    @GET("2.1/nobelPrizes")
    suspend fun getNobelPrizes(
        @Query("limit") limit: Int = 30,
        @Query("sort") sort: String = "desc",
        @Query("nobelPrizeYear") yearFrom: Int,
        @Query("yearTo") yearTo: Int,
        @Query("nobelPrizeCategory") category: String = categories[Cat.PHYSICS]!!,
        @Query("format") format: String = "json"
    ) : Response<NobelPrizeResponse>
}