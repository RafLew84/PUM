package com.example.repositorybasicsjava.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.repositorybasicsjava.model.User;
import com.example.repositorybasicsjava.repository.UserRepository;

import java.util.List;

public class UserViewModel extends ViewModel {

    private UserRepository userRepository;
    private final MutableLiveData<List<User>> usersList = new MutableLiveData<>();
    public LiveData<List<User>> getUsersList() {
        return usersList;
    }

    public UserViewModel() {
        userRepository = new UserRepository();
        loadUsers();
    }

    private void loadUsers(){
        usersList.setValue(userRepository.getUsers());
    }

}
