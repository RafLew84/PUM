package com.example.repositorybasicscompose.repository

import com.example.repositorybasicscompose.dummydata.DataProvider
import com.example.repositorybasicscompose.model.User
import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUsers(): List<User> {
        delay(700L)
        return DataProvider.users
    }
}