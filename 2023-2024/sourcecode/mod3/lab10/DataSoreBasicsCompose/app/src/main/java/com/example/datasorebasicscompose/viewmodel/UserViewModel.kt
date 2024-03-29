package com.example.datasorebasicscompose.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datasorebasicscompose.data.SaveUsernameDataStore
import com.example.datasorebasicscompose.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : ViewModel() {
    private val repository: UserRepository
    private val _username = MutableStateFlow("")
    val username: StateFlow<String>
        get() = _username

    init {
        repository = UserRepository(application)
        fetchUser()
    }

    private fun fetchUser() {
        viewModelScope.launch {
            repository.getUsername().collect { username ->
                _username.value = username
            }
        }
    }

    fun addUsername(username: String) {
        viewModelScope.launch {
            repository.add(username)
        }
    }

    fun clearUsername(){
        viewModelScope.launch {
            repository.clear()
        }
    }
}