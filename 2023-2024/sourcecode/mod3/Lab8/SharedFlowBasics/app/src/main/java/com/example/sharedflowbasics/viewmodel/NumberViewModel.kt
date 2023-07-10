package com.example.sharedflowbasics.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow

class NumberViewModel : ViewModel() {

    private val _sharedFlow = MutableStateFlow(120)
    val sharedFlow = _sharedFlow.asSharedFlow()


}