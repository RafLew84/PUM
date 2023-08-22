package com.example.datasorebasicscompose.repository

import android.app.Application
import com.example.datasorebasicscompose.data.SaveUsernameDataStore

class UserRepository(private val application: Application) {
    fun getUsername() = SaveUsernameDataStore.getUsernameFlow(application)
    suspend fun add(username: String) = SaveUsernameDataStore.storeUsername(application, username)
    suspend fun clear() = SaveUsernameDataStore.storeUsername(application, "")
}