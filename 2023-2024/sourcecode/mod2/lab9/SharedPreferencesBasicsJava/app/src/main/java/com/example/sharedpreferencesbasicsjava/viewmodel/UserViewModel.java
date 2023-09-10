package com.example.sharedpreferencesbasicsjava.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sharedpreferencesbasicsjava.repository.UserRepository;

public class UserViewModel extends AndroidViewModel {
    private final UserRepository repository = new UserRepository(getApplication());

    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getUsername() {
        return repository.getUsername();
    }

    public void clearUsers() {
        repository.clear();
    }

    public void addUser(String username) {
        repository.add(username);
    }
}
