package com.example.datastorebasicskotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datastorebasicskotlin.data.SaveUsernameDataStore
import com.example.datastorebasicskotlin.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository
    private val _username = MutableStateFlow("")
    val username: StateFlow<String>
        get() = _username

    init {
        repository = UserRepository(SaveUsernameDataStore(application))
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