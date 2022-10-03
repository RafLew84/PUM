package pl.udu.uwr.pum.foody.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pl.udu.uwr.pum.foody.data.Meal
import pl.udu.uwr.pum.foody.data.MealResponse
import pl.udu.uwr.pum.foody.db.MealDatabase
import pl.udu.uwr.pum.foody.repository.FoodRepository
import pl.udu.uwr.pum.foody.util.Resource
import retrofit2.Response

class FoodViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: FoodRepository
    private val _mealList: MutableLiveData<Resource<MealResponse>> = MutableLiveData()
    private val _meal: MutableLiveData<Resource<MealResponse>> = MutableLiveData()

    val mealList: LiveData<Resource<MealResponse>>
        get() = _mealList

    val meal: LiveData<Resource<MealResponse>>
        get() = _meal

    val readAllData: LiveData<List<Meal>>

    init {
        //getMealList()
        val foodDao = MealDatabase.getDatabase(application).foodDao()
        repository = FoodRepository(foodDao)
        readAllData = repository.readAllData
    }

    fun getMealList() = viewModelScope.launch {
        _mealList.postValue(Resource.Loading())
        val response = repository.getFood()
        _mealList.postValue(handleMealResponse(response))
    }

    private fun handleMealResponse(response: Response<MealResponse>)
            : Resource<MealResponse> {
        if (response.isSuccessful)
            response.body()?.let { return Resource.Success(it) }
        return Resource.Error(response.message())
    }

    fun getMealById(id: String) = viewModelScope.launch {
        _meal.postValue(Resource.Loading())
        val response = repository.getFoodById(id)
        _meal.postValue(handleMealResponse(response))
    }

    fun insert(meal: Meal) = viewModelScope.launch {
        repository.insert(meal)
    }

    fun delete(meal: Meal) = viewModelScope.launch {
        repository.delete(meal)
    }
}