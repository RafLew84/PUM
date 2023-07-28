package com.example.roombasicsjava.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.roombasicsjava.data.User;
import com.example.roombasicsjava.data.UserDao;
import com.example.roombasicsjava.data.UserDatabase;
import com.example.roombasicsjava.repository.UserRepository;
import com.example.roombasicsjava.util.AppExecutors;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private final UserRepository repository;
    private LiveData<List<User>> users;

    public UserViewModel(@NonNull Application application) {
        super(application);
        UserDatabase db = UserDatabase.getDatabase(application);
        UserDao dao = db.userDao();
        repository = new UserRepository(dao);

        fetchUsers();
    }

    private void fetchUsers() {
        users = repository.getUsers();
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    public void clearUsers() {
        AppExecutors.getInstance().diskIO().execute(repository::clear);
    }

    public void addUser(User user) {
        AppExecutors.getInstance().diskIO().execute(() -> repository.add(user));
    }
}
