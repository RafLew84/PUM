package com.example.roombasicscompose.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roombasicscompose.data.User
import com.example.roombasicscompose.data.UserDatabase
import com.example.roombasicscompose.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : ViewModel() {

    private val repository: UserRepository
    private val _usersState = MutableStateFlow<List<User>>(emptyList())
    val usersState: StateFlow<List<User>>
        get() = _usersState

    init {
        val db = UserDatabase.getDatabase(application)
        val dao = db.userDao()
        repository = UserRepository(dao)

        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            repository.getUsers().collect { users ->
                _usersState.value = users
            }
        }
    }

    fun clearUsers() {
        viewModelScope.launch {
            repository.clear()
        }
    }

    fun addUser(user: User) {
        viewModelScope.launch {
            repository.add(user)
        }
    }
}