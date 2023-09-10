package com.example.repositorybasicskotlin.repository

import com.example.repositorybasicskotlin.dummydata.DataProvider
import com.example.repositorybasicskotlin.model.User
import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUsers(): List<User> {
        delay(700L)
        return DataProvider.users
    }
}