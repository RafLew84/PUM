package pl.udu.uwr.pum.foody.api

import pl.udu.uwr.pum.foody.data.MealResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi {
    @GET("api/json/v1/1/filter.php?a=Polish")
    suspend fun getFood() : Response<MealResponse>

    @GET("api/json/v1/1/lookup.php?")
    suspend fun getFoodById(@Query("i") id: String) : Response<MealResponse>
}