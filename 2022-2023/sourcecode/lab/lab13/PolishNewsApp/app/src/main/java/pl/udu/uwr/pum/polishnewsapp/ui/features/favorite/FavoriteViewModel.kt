package pl.udu.uwr.pum.polishnewsapp.ui.features.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.NewsArticle
import pl.udu.uwr.pum.polishnewsapp.data.repo.NewsRepository
import javax.inject.Inject


@HiltViewModel
class FavoriteViewModel @Inject constructor (
    private val repository: NewsRepository
) : ViewModel() {
    val favorites = repository.getAllFavoriteArticles()
        .stateIn(viewModelScope, SharingStarted.Lazily, null)

    fun addFavorite(newsArticle: NewsArticle){
        val favorite = newsArticle.isFavorite
        val updatedArticle = newsArticle.copy(isFavorite = !favorite)
        viewModelScope.launch { repository.updateArticle(updatedArticle) }
    }
}