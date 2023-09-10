package com.example.datastorebasicskotlin.repository

import android.app.Application
import com.example.datastorebasicskotlin.data.SaveUsernameDataStore


class UserRepository(private val application: Application) {
    fun getUsername() = SaveUsernameDataStore.getUsernameFlow(application)
    suspend fun add(username: String) = SaveUsernameDataStore.storeUsername(application, username)
    suspend fun clear() = SaveUsernameDataStore.storeUsername(application, "")
}