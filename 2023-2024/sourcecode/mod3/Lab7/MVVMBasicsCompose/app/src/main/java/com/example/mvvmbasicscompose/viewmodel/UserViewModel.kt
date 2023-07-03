package com.example.mvvmbasicscompose.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.mvvmbasicscompose.dummydata.DataProvider
import com.example.mvvmbasicscompose.model.User

class UserViewModel : ViewModel() {
    private var _usersList = mutableStateListOf<User>()
    val usersList: List<User>
        get() = _usersList

    init {
        reinitialize()
    }

    fun addUser(user: User){
        _usersList.add(user)
        _usersList.sortBy { it.lastName }
    }

    fun reinitialize(){
        _usersList.clear()
        _usersList.addAll(DataProvider.users)
        _usersList.sortBy { it.lastName }
    }

    fun clear(){
        _usersList.clear()
    }
}