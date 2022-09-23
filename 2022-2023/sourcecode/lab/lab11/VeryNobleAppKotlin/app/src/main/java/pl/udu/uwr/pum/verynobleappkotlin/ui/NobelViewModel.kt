package pl.udu.uwr.pum.verynobleappkotlin.ui

import androidx.lifecycle.ViewModel
import pl.udu.uwr.pum.verynobleappkotlin.repository.NobelRepository

class NobelViewModel() : ViewModel() {
    private val repository: NobelRepository
    init {
        repository = NobelRepository()
    }
}