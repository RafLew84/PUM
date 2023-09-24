package com.example.flowbasicscompose.viewmodel

import androidx.lifecycle.ViewModel
import com.example.flowbasicscompose.data.DataProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class WordsViewModel : ViewModel() {
    val wordsFlow = flow{
        var index = 0
        while (index < DataProvider.data.size){
            emit(DataProvider.data[index])
            delay(500L)
            index++
        }
    }
}