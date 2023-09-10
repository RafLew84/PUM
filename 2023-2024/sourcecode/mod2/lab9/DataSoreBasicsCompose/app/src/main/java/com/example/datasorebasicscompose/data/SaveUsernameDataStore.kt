package com.example.datasorebasicscompose.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object SaveUsernameDataStore {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("user_prefs")
    private val USERNAME_KEY = stringPreferencesKey("USERNAME")

    suspend fun storeUsername(context: Context, username: String) {
        context.dataStore.edit { preferences ->
            preferences[USERNAME_KEY] = username
        }
    }

    fun getUsernameFlow(context: Context): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[USERNAME_KEY] ?: ""
        }
    }
}
