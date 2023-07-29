package com.example.datastorebasicskotlin.repository

import com.example.datastorebasicskotlin.data.SaveUsernameDataStore


class UserRepository(private val saveUsernameDataStore: SaveUsernameDataStore) {
    fun getUsername() = saveUsernameDataStore.username
    suspend fun add(username: String) = saveUsernameDataStore.storeUsername(username)
    suspend fun clear() = saveUsernameDataStore.storeUsername("")
}