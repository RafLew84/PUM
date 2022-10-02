package pl.udu.uwr.pum.foody.repository

import pl.udu.uwr.pum.foody.api.RetrofitInstance

class FoodRepository {
    suspend fun getFood() = RetrofitInstance.api.getFood()
    suspend fun getFoodById(id: String) = RetrofitInstance.api.getFoodById(id)
}