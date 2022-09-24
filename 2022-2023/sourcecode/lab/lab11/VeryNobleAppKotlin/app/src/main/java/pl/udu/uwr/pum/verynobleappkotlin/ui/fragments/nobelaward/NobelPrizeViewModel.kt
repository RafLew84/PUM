package pl.udu.uwr.pum.verynobleappkotlin.ui.fragments.nobelaward

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.udu.uwr.pum.verynobleappkotlin.data.nobelprizeresponse.NobelPrizeResponse
import pl.udu.uwr.pum.verynobleappkotlin.repository.NobelRepository
import pl.udu.uwr.pum.verynobleappkotlin.util.Resource
import retrofit2.Response

class NobelPrizeViewModel : ViewModel() {
    private val repository: NobelRepository = NobelRepository()
    private val _nobelPrize: MutableLiveData<Resource<NobelPrizeResponse>> = MutableLiveData()

    val noblePrize: LiveData<Resource<NobelPrizeResponse>>
        get() = _nobelPrize

    fun getNobelPrize(year: Int, category: String) = viewModelScope.launch {
        _nobelPrize.postValue(Resource.Loading())
        val response = repository.getNobelPrize(year= year, category= category)
        _nobelPrize.postValue(handleNobelPrizesResponse(response))
    }

    private fun handleNobelPrizesResponse(response: Response<NobelPrizeResponse>)
            : Resource<NobelPrizeResponse> {
        if (response.isSuccessful)
            response.body()?.let { return Resource.Success(it) }
        return Resource.Error(response.message())
    }
}