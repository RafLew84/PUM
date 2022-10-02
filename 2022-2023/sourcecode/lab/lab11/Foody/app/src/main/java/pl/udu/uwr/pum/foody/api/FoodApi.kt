package pl.udu.uwr.pum.foody.api

import pl.udu.uwr.pum.foody.data.list.MealResponse
import retrofit2.Response
import retrofit2.http.GET

interface FoodApi {
    @GET("api/json/v1/1/filter.php?a=Polish")
    suspend fun getFood() : Response<MealResponse>
}