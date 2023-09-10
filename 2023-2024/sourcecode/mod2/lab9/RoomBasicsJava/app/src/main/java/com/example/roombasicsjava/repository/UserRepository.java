package com.example.roombasicsjava.repository;

import androidx.lifecycle.LiveData;

import com.example.roombasicsjava.data.User;
import com.example.roombasicsjava.data.UserDao;

import java.util.List;

public class UserRepository {
    private final UserDao userDao;

    public UserRepository(UserDao userDao) {
        this.userDao = userDao;
    }

    public LiveData<List<User>> getUsers() {
        return userDao.getUsers();
    }

    public void clear() {
        userDao.deleteAll();
    }

    public void add(User user) {
        userDao.insert(user);
    }
}
