package com.example.mvvmbasicsjava.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmbasicsjava.dummydata.DataProvider;
import com.example.mvvmbasicsjava.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserViewModel extends ViewModel {
    private final MutableLiveData<List<User>> usersList = new MutableLiveData<>();
    public LiveData<List<User>> getUsersList() {
        return usersList;
    }

    public UserViewModel() {
        reinitialize();
    }

    public void addUser(User user) {
        if (usersList.getValue() != null) {
            List<User> currentList = new ArrayList<>(usersList.getValue());
            currentList.add(user);
            currentList.sort(Comparator.comparing(User::getLastName));
            usersList.setValue(currentList);
        }
    }

    public void reinitialize() {
        List<User> sortedUsers = new ArrayList<>(DataProvider.getUsers());
        sortedUsers.sort((user1, user2) -> {
            if (user1.equals(user2)) { return 0; }
            int result = user1.getLastName().compareTo(user2.getLastName());
            if (result == 0) {
                return user1.getFirstName().compareTo(user2.getFirstName());
            }
            return result;
        });
        usersList.setValue(sortedUsers);
    }

    public void clear() {
        usersList.setValue(Collections.emptyList());
    }
}
