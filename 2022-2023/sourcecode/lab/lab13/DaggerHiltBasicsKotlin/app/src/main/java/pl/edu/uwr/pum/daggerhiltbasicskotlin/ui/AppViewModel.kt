package pl.edu.uwr.pum.daggerhiltbasicskotlin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pl.edu.uwr.pum.daggerhiltbasicskotlin.data.Post
import pl.edu.uwr.pum.daggerhiltbasicskotlin.data.repository.AppRepository
import pl.edu.uwr.pum.daggerhiltbasicskotlin.util.Resource
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor (
    private val repository: AppRepository
) : ViewModel() {
    private var _posts: MutableLiveData<Resource<List<Post>>> = MutableLiveData()

    val posts: LiveData<Resource<List<Post>>>
        get() = _posts

    fun getPosts() = viewModelScope.launch {
        _posts.postValue(Resource.Loading())
        val response = repository.getPosts()
        _posts.postValue(handleMealResponse(response))
    }

    private fun handleMealResponse(response: Response<List<Post>>)
            : Resource<List<Post>> {
        if (response.isSuccessful)
            response.body()?.let { return Resource.Success(it) }
        return Resource.Error(response.message())
    }
}