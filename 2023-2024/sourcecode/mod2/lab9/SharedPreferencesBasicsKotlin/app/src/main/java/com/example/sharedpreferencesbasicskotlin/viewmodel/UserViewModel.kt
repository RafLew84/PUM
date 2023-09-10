package com.example.sharedpreferencesbasicskotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.sharedpreferencesbasicskotlin.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository = UserRepository(application)
    private val _username: MutableStateFlow<String> = MutableStateFlow(repository.username)

    val username: StateFlow<String>
        get() = _username

    fun addUsername(username: String) {
        repository.add(username)
        _username.value = username
    }

    fun clearUsername() {
        repository.clear()
        _username.value = ""
    }
}