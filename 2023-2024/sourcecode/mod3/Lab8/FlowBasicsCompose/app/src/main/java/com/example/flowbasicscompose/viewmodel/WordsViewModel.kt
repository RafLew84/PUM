package com.example.flowbasicscompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flowbasicscompose.data.DataProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class WordsViewModel : ViewModel() {
    val wordsFlow = flow{
        var index = 0
        while (index < DataProvider.data.size){
            emit(DataProvider.data[index])
            delay(500L)
            index++
        }
    }

    private fun collectFlow(){
        viewModelScope.launch {
            wordsFlow
                .filter { word ->
                    word == "trzeci"
                }
                .map { word ->
                    word.plus(" zmiana")
                }
        }
    }
}