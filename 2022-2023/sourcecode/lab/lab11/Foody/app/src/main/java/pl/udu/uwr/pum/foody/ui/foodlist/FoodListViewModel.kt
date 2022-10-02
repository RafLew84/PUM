package pl.udu.uwr.pum.foody.ui.foodlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.udu.uwr.pum.foody.data.list.MealResponse
import pl.udu.uwr.pum.foody.repository.FoodRepository
import pl.udu.uwr.pum.foody.util.Resource
import retrofit2.Response

class FoodListViewModel : ViewModel() {
    private val repository = FoodRepository()
    private val _mealList: MutableLiveData<Resource<MealResponse>> = MutableLiveData()

    val mealList: LiveData<Resource<MealResponse>>
        get() = _mealList

    init {
        getMealList()
    }

    private fun getMealList() = viewModelScope.launch {
        _mealList.postValue(Resource.Loading())
        val response = repository.getFood()
        _mealList.postValue(handleMealResponse(response))
    }

    private fun handleMealResponse(response: Response<MealResponse>)
            : Resource<MealResponse>{
        if (response.isSuccessful)
            response.body()?.let { return Resource.Success(it) }
        return Resource.Error(response.message())
    }
}