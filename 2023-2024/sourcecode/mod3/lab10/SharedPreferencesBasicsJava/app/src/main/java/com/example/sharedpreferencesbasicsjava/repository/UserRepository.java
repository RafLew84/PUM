package com.example.sharedpreferencesbasicsjava.repository;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class UserRepository {

    private final SharedPreferences sharedPref;
    private final MutableLiveData<String> _username = new MutableLiveData<>();

    public UserRepository(Application application) {
        sharedPref = application.getSharedPreferences("fileName", Context.MODE_PRIVATE);
        _username.setValue(sharedPref.getString("username", ""));
    }

    public LiveData<String> getUsername() {
        return _username;
    }

    public void add(String newUsername) {
        SharedPreferences.Editor edit = sharedPref.edit();
        edit.putString("username", newUsername).apply();
        _username.setValue(newUsername);
    }

    public void clear() {
        SharedPreferences.Editor edit = sharedPref.edit();
        edit.putString("username", "").apply();
        _username.setValue("");
    }
}
