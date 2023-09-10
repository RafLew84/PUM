package com.example.viewmodelbasics_compose.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.viewmodelbasics_compose.data.DataProvider

class WordViewModel : ViewModel() {
    private var _wordsList = mutableStateListOf<String>()
    val wordList: List<String>
        get() = _wordsList

    init {
        reinitialize()
    }

    fun addWord(word: String){
        _wordsList.add(word)
        _wordsList.sort()
    }

    fun reinitialize(){
        _wordsList.clear()
        _wordsList.addAll(DataProvider.words)
        _wordsList.sort()
    }

    fun clear(){
        _wordsList.clear()
    }
}