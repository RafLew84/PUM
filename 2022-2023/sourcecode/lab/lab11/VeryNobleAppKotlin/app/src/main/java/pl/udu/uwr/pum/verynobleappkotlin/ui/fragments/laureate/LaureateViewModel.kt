package pl.udu.uwr.pum.verynobleappkotlin.ui.fragments.laureate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.LaureateResponse
import pl.udu.uwr.pum.verynobleappkotlin.repository.NobelRepository
import pl.udu.uwr.pum.verynobleappkotlin.util.Resource
import retrofit2.Response

class LaureateViewModel : ViewModel() {
    private val repository = NobelRepository()
    private val _laureate: MutableLiveData<Resource<LaureateResponse>> = MutableLiveData()

    val laureate: LiveData<Resource<LaureateResponse>>
        get() = _laureate

    fun getLaureate(id: String) = viewModelScope.launch {
        _laureate.postValue(Resource.Loading())
        val response = repository.getLaureate(id)
        _laureate.postValue(handleLaureateResponse(response))
    }

    private fun handleLaureateResponse(response: Response<LaureateResponse>)
            : Resource<LaureateResponse> {
        if (response.isSuccessful)
            response.body()?.let { return Resource.Success(it) }
        return Resource.Error(response.message())
    }
}