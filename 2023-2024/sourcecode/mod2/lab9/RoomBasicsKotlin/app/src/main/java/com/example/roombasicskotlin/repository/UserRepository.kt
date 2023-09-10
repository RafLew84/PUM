package com.example.roombasicskotlin.repository

import com.example.roombasicskotlin.data.User
import com.example.roombasicskotlin.data.UserDao

class UserRepository(private val userDao: UserDao) {
    fun getUsers() = userDao.getUsers()
    suspend fun clear() = userDao.deleteAll()
    suspend fun add(user: User) = userDao.insert(user)
}