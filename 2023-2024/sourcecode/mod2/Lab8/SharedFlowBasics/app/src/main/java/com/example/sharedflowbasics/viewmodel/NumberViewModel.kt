package com.example.sharedflowbasics.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class NumberViewModel : ViewModel() {

    private var number = 0
    private val _sharedFlow = MutableSharedFlow<Int>(1)
    val sharedFlow: SharedFlow<Int> = _sharedFlow

    init {
        viewModelScope.launch {
            while (true) {
                _sharedFlow.emit(number++)
                delay(500L)
            }
        }
    }
}