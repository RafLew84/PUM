package com.example.sharedpreferencesbasicskotlin.repository

import android.app.Application
import android.content.Context.MODE_PRIVATE

class UserRepository(application: Application) {

    private val sharedPref = application.getSharedPreferences("fileName", MODE_PRIVATE)

    private var _username: String = sharedPref.getString("username", "") ?: ""
    val username: String
        get() = _username

    fun add(newUsername: String) {
        val edit = sharedPref.edit()
        edit.putString("username", newUsername).apply()
        _username = newUsername
    }

    fun clear() {
        val edit = sharedPref.edit()
        edit.putString("username", "").apply()
        _username = ""
    }
}