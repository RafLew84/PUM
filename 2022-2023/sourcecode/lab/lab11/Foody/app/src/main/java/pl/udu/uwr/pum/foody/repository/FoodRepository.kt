package pl.udu.uwr.pum.foody.repository

import androidx.lifecycle.LiveData
import pl.udu.uwr.pum.foody.api.RetrofitInstance
import pl.udu.uwr.pum.foody.data.Meal
import pl.udu.uwr.pum.foody.db.FoodDao

class FoodRepository(private val foodDao: FoodDao) {
    suspend fun getFood() = RetrofitInstance.api.getFood()
    suspend fun getFoodById(id: String) = RetrofitInstance.api.getFoodById(id)

    val readAllData: LiveData<List<Meal>> = foodDao.getAllMeals()
    suspend fun insert(meal: Meal) = foodDao.insert(meal)
    suspend fun delete(meal: Meal) = foodDao.delete(meal)
}