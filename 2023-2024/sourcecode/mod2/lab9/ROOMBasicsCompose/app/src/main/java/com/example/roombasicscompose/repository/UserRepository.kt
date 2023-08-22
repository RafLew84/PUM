package com.example.roombasicscompose.repository

import com.example.roombasicscompose.data.User
import com.example.roombasicscompose.data.UserDao

class UserRepository(private val userDao: UserDao) {
    fun getUsers() = userDao.getUsers()
    suspend fun clear() = userDao.deleteAll()
    suspend fun add(user: User) = userDao.insert(user)
}