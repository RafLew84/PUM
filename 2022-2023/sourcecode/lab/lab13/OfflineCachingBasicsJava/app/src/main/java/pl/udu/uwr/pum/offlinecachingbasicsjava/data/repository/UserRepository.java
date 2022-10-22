package pl.udu.uwr.pum.offlinecachingbasicsjava.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import pl.udu.uwr.pum.offlinecachingbasicsjava.data.User;
import pl.udu.uwr.pum.offlinecachingbasicsjava.data.db.UserDao;
import pl.udu.uwr.pum.offlinecachingbasicsjava.data.remote.RandomApi;
import pl.udu.uwr.pum.offlinecachingbasicsjava.util.NetworkBoundResource;
import pl.udu.uwr.pum.offlinecachingbasicsjava.util.Resource;
import retrofit2.Call;

public class UserRepository {

    private final UserDao dao;
    private final RandomApi api;

    @Inject
    public UserRepository(UserDao dao, RandomApi api) {
        this.dao = dao;
        this.api = api;
    }

    public LiveData<Resource<List<User>>> getUsers() {
        return new NetworkBoundResource<List<User>, List<User>>() {

            @Override
            protected void saveCallResult(@NonNull List<User> item) {
                dao.clear();
                dao.insert(item);
            }

            @NonNull
            @Override
            protected LiveData<List<User>> loadFromDb() {return dao.getUsers();}

            @NonNull
            @Override
            protected Call<List<User>> createCall() {
                return api.users();
            }
        }.getAsLiveData();
    }
}
