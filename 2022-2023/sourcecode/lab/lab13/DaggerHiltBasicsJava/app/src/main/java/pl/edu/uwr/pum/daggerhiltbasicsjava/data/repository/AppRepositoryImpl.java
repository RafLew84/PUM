package pl.edu.uwr.pum.daggerhiltbasicsjava.data.repository;

import java.util.List;

import pl.edu.uwr.pum.daggerhiltbasicsjava.data.Post;
import pl.edu.uwr.pum.daggerhiltbasicsjava.data.remote.PlaceholderApi;
import pl.edu.uwr.pum.daggerhiltbasicsjava.domain.remote.AppRepository;
import retrofit2.Call;

public class AppRepositoryImpl implements AppRepository {
    private final PlaceholderApi api;

    public AppRepositoryImpl(PlaceholderApi api) {
        this.api = api;
    }

    @Override
    public Call<List<Post>> getPosts() {
        return api.getPosts();
    }
}
