package pl.edu.uwr.pum.daggerhiltbasicsjava.domain.remote;

import java.util.List;

import pl.edu.uwr.pum.daggerhiltbasicsjava.data.Post;
import retrofit2.Call;

public interface AppRepository {
    Call<List<Post>> getPosts();
}
