package com.example.mvvmbasicskotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmbasicskotlin.dummydata.DataProvider
import com.example.mvvmbasicskotlin.model.User

class UserViewModel : ViewModel() {
    private var _usersList = MutableLiveData<List<User>>()
    val usersList: LiveData<List<User>>
        get() = _usersList

    init {
        reinitialize()
    }

    fun addUser(user: User){
        val currentList = _usersList.value.orEmpty().toMutableList()
        currentList.add(user)
        currentList.sortBy { it.lastName }
        _usersList.value = currentList
    }

    fun reinitialize(){
        val sortedUsers = DataProvider.users.sortedWith(compareBy(User::lastName, User::firstName))
        _usersList.value = sortedUsers
    }

    fun clear(){
        _usersList.value = emptyList()
    }
}