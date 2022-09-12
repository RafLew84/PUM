package pl.udu.uwr.pum.retrofitputpatchdeletebasicsjava;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
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
