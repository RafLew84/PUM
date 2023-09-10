package com.example.livedatabasics_kotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private var _counter = MutableLiveData(0)
    val counter: LiveData<Int>
        get() = _counter

    fun increase(){
        _counter.value = _counter.value?.inc()
    }

    fun decrease(){
        _counter.value = _counter.value?.dec()
    }

    fun clear(){ _counter.value = 0 }
}