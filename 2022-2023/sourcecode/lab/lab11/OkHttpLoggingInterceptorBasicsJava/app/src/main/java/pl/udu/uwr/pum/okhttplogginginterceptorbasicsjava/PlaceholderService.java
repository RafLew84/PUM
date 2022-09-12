package pl.udu.uwr.pum.okhttplogginginterceptorbasicsjava;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PlaceholderService {

    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int postId, @Body Post post);

    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int postId, @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int postId);
}
