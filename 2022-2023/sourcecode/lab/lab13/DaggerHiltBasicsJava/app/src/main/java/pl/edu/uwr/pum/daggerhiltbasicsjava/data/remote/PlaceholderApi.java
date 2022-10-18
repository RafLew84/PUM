package pl.edu.uwr.pum.daggerhiltbasicsjava.data.remote;

import java.util.List;

import pl.edu.uwr.pum.daggerhiltbasicsjava.data.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PlaceholderApi {

    @GET("posts")
    Call<List<Post>> getPosts();
}
