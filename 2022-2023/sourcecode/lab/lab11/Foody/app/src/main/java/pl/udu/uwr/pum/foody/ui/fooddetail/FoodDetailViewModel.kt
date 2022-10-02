package pl.udu.uwr.pum.foody.ui.fooddetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.udu.uwr.pum.foody.data.MealResponse
import pl.udu.uwr.pum.foody.repository.FoodRepository
import pl.udu.uwr.pum.foody.util.Resource
import retrofit2.Response

class FoodDetailViewModel : ViewModel() {
    private val repository = FoodRepository()
    private val _meal: MutableLiveData<Resource<MealResponse>> = MutableLiveData()

    val meal: LiveData<Resource<MealResponse>>
        get() = _meal

    fun getMealById(id: String) = viewModelScope.launch {
        _meal.postValue(Resource.Loading())
        val response = repository.getFoodById(id)
        _meal.postValue(handleMealResponse(response))
    }

    private fun handleMealResponse(response: Response<MealResponse>)
            : Resource<MealResponse> {
        if (response.isSuccessful)
            response.body()?.let { return Resource.Success(it) }
        return Resource.Error(response.message())
    }
}