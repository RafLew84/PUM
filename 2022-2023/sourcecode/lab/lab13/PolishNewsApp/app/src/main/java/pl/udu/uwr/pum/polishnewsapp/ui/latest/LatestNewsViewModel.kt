package pl.udu.uwr.pum.polishnewsapp.ui.latest

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.udu.uwr.pum.polishnewsapp.data.repo.NewsRepository
import javax.inject.Inject

@HiltViewModel
class LatestNewsViewModel @Inject constructor (
    private val repository: NewsRepository
        ) : ViewModel() {}