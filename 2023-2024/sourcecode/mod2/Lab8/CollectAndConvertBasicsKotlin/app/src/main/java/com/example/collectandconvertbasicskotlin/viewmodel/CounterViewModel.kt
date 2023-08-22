package com.example.collectandconvertbasicskotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class CounterViewModel : ViewModel() {
    private var currentVal = 0

    val counter = flow {
        while (true){
            delay(500L)
            emit(currentVal++)
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        0
    )
}