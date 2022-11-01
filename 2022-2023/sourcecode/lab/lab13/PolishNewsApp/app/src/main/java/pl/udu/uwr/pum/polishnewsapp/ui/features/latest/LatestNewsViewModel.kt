package pl.udu.uwr.pum.polishnewsapp.ui.features.latest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import pl.udu.uwr.pum.polishnewsapp.data.repo.NewsRepository
import pl.udu.uwr.pum.polishnewsapp.util.Resource
import javax.inject.Inject

@HiltViewModel
class LatestNewsViewModel @Inject constructor(repository: NewsRepository) : ViewModel() {

    private val eventChannel = Channel<Event>()
    val events = eventChannel.receiveAsFlow()

    private val refreshChannelTrigger = Channel<Unit>()
    private val refreshTrigger = refreshChannelTrigger.receiveAsFlow()

    var pendingScrollToTop = false

    val latestNews = refreshTrigger.flatMapLatest {
        repository.getLatestNews(
            fetchFail = { t ->
                viewModelScope.launch { eventChannel.send(Event.ShowErrorMessage(t)) }
            },
            fetchSuccess = { pendingScrollToTop = true }
        )
    }.stateIn(viewModelScope, SharingStarted.Lazily, null)


    fun refreshOnDemand() {
        if (latestNews.value !is Resource.Loading)
            viewModelScope.launch { refreshChannelTrigger.send(Unit) }
    }

    fun refreshOnStart() {
        if (latestNews.value !is Resource.Loading)
            viewModelScope.launch { refreshChannelTrigger.send(Unit) }
    }

    sealed class Event {
        data class ShowErrorMessage(val t: Throwable) : Event()
    }
}