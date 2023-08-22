package com.example.repositorybasicsjava.repository;

import com.example.repositorybasicsjava.dummydata.DataProvider;
import com.example.repositorybasicsjava.model.User;

import java.util.List;

public class UserRepository {
    public List<User> getUsers(){
        return DataProvider.getUsers();
    }
}
