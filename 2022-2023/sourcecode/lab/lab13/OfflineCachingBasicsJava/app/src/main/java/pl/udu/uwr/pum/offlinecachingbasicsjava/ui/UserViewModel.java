package pl.udu.uwr.pum.offlinecachingbasicsjava.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import pl.udu.uwr.pum.offlinecachingbasicsjava.data.User;
import pl.udu.uwr.pum.offlinecachingbasicsjava.data.repository.UserRepository;
import pl.udu.uwr.pum.offlinecachingbasicsjava.util.Resource;

@HiltViewModel
public class UserViewModel extends ViewModel {
    private LiveData<Resource<List<User>>> users;
    private final UserRepository repository;

    @Inject
    public UserViewModel(UserRepository repository) {
        this.repository = repository;

    }

    public LiveData<Resource<List<User>>> getUsers() {
        return repository.getUsers();
    }
}
