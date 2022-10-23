package pl.edu.uwr.pum.daggerhiltbasicsjava.data.repository;

import java.util.List;

import pl.edu.uwr.pum.daggerhiltbasicsjava.data.Post;
import pl.edu.uwr.pum.daggerhiltbasicsjava.data.remote.PlaceholderApi;
import retrofit2.Call;

public class AppRepository {
    private final PlaceholderApi api;

    public AppRepository(PlaceholderApi api) {
        this.api = api;
    }

    public Call<List<Post>> getPosts() {
        return api.getPosts();
    }
}
