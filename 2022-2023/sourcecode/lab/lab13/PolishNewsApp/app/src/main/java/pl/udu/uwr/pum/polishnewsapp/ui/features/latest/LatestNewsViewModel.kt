package pl.udu.uwr.pum.polishnewsapp.ui.features.latest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import pl.udu.uwr.pum.polishnewsapp.data.repo.NewsRepository
import javax.inject.Inject

@HiltViewModel
class LatestNewsViewModel @Inject constructor (repository: NewsRepository) : ViewModel() {
    val latestNews = repository.getLatestNews()
        .stateIn(viewModelScope, SharingStarted.Lazily, null)
}