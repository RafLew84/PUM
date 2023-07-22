package com.example.repositorybasicskotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repositorybasicskotlin.model.User
import com.example.repositorybasicskotlin.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val userRepository = UserRepository()

    private val _usersList = MutableStateFlow<List<User>>(emptyList())
    val usersList: StateFlow<List<User>> get() = _usersList

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            _usersList.value = userRepository.getUsers()
        }
    }
}