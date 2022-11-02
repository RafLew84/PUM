package pl.udu.uwr.pum.polishnewsapp.ui.features.latest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.NewsArticle
import pl.udu.uwr.pum.polishnewsapp.data.repo.NewsRepository
import pl.udu.uwr.pum.polishnewsapp.util.Resource
import pl.udu.uwr.pum.polishnewsapp.util.TIME_TO_DELETE_NOT_FAVORITE_ARTICLES
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class LatestNewsViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {

    private val eventChannel = Channel<Event>()
    val events = eventChannel.receiveAsFlow()

    private val refreshChannelTrigger = Channel<Refresh>()
    private val refreshTrigger = refreshChannelTrigger.receiveAsFlow()

    var pendingScrollToTop = false

    @OptIn(ExperimentalCoroutinesApi::class)
    val latestNews = refreshTrigger.flatMapLatest { refresh ->
        repository.getLatestNews(
            refresh == Refresh.REQUEST,
            fetchFail = { t ->
                viewModelScope.launch { eventChannel.send(Event.ShowErrorMessage(t)) }
            },
            fetchSuccess = { pendingScrollToTop = true }
        )
    }.stateIn(viewModelScope, SharingStarted.Lazily, null)

    init {
        viewModelScope.launch {
            repository.deleteNonFavoriteArticlesOlderThan(
                System.currentTimeMillis() - TIME_TO_DELETE_NOT_FAVORITE_ARTICLES
            )
        }
    }


    fun refreshOnDemand() {
        if (latestNews.value !is Resource.Loading)
            viewModelScope.launch { refreshChannelTrigger.send(Refresh.REQUEST) }
    }

    fun refreshOnStart() {
        if (latestNews.value !is Resource.Loading)
            viewModelScope.launch { refreshChannelTrigger.send(Refresh.NORMAL) }
    }

    fun addFavorite(newsArticle: NewsArticle){
        val favorite = newsArticle.isFavorite
        val updatedArticle = newsArticle.copy(isFavorite = !favorite)
        viewModelScope.launch { repository.updateArticle(updatedArticle) }
    }

    enum class Refresh {
        REQUEST, NORMAL
    }

    sealed class Event {
        data class ShowErrorMessage(val t: Throwable) : Event()
    }
}