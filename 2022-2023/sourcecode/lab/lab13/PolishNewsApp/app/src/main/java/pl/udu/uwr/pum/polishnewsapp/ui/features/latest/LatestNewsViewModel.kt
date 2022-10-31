package pl.udu.uwr.pum.polishnewsapp.ui.features.latest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.NewsArticle
import pl.udu.uwr.pum.polishnewsapp.data.repo.NewsRepository
import javax.inject.Inject

@HiltViewModel
class LatestNewsViewModel @Inject constructor (
    private val repository: NewsRepository
        ) : ViewModel() {

    private val _latestNews = MutableLiveData<List<NewsArticle>>()
    val latestNews: LiveData<List<NewsArticle>>
        get() = _latestNews

    fun getLatestNews() {
        viewModelScope.launch {
            _latestNews.value = repository.getLatestNews()
        }
    }
}