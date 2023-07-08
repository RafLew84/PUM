package com.example.flowbasicskotlin.viewmodel

import androidx.lifecycle.ViewModel
import com.example.flowbasicskotlin.data.DataProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class WordViewModel : ViewModel() {
    val wordsFlow = flow{
        var index = 0
        while (index < DataProvider.data.size){
            emit(DataProvider.data[index])
            delay(500L)
            index++
        }
    }
}