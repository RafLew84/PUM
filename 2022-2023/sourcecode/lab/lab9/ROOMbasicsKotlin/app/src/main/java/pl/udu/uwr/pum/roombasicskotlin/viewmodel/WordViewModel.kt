package pl.udu.uwr.pum.roombasicskotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.udu.uwr.pum.roombasicskotlin.model.Word
import pl.udu.uwr.pum.roombasicskotlin.model.WordRoomDatabase

class WordViewModel(application: Application) : AndroidViewModel(application) {
    private val db: WordRoomDatabase
    val getAllWords: LiveData<List<Word>>

    fun insert(word: Word) {
        viewModelScope.launch{
            db.wordDao().insert(word)
        }
    }

    init {
        db = WordRoomDatabase.getDatabase(application)
        getAllWords = db.wordDao().getAlphabetizedWords()
    }
}