package pl.udu.uwr.pum.verynobleappkotlin.ui.fragments.nobleawards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.udu.uwr.pum.verynobleappkotlin.data.nobelprizeresponse.NobelPrizeResponse
import pl.udu.uwr.pum.verynobleappkotlin.repository.NobelRepository
import pl.udu.uwr.pum.verynobleappkotlin.util.Cat
import pl.udu.uwr.pum.verynobleappkotlin.util.Resource
import pl.udu.uwr.pum.verynobleappkotlin.util.categories
import retrofit2.Response

class NobelPrizesViewModel : ViewModel() {
    private val repository: NobelRepository = NobelRepository()
    private val _nobelPrizes: MutableLiveData<Resource<NobelPrizeResponse>> = MutableLiveData()

    init {
        categories[Cat.PHYSICS]?.let { getNobelPrizes(category = it) }
    }

    val noblePrizes: LiveData<Resource<NobelPrizeResponse>>
        get() = _nobelPrizes

    fun getNobelPrizes(category: String) = viewModelScope.launch {
        _nobelPrizes.postValue(Resource.Loading())
        val response = repository.getNobelPrizes(category= category)
        _nobelPrizes.postValue(handleNobelPrizesResponse(response))
    }

    private fun handleNobelPrizesResponse(response: Response<NobelPrizeResponse>)
    : Resource<NobelPrizeResponse>{
        if (response.isSuccessful)
            response.body()?.let { return Resource.Success(it) }
        return Resource.Error(response.message())
    }
}