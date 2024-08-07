package com.example.viewmodelbasics_kotlin.viewmodel

import androidx.lifecycle.ViewModel
import com.example.viewmodelbasics_kotlin.data.DataProvider

class WordViewModel : ViewModel() {
    private var _wordsList: MutableList<String> = mutableListOf()
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