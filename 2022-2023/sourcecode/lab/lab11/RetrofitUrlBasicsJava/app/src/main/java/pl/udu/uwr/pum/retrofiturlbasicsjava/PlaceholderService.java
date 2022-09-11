package pl.udu.uwr.pum.retrofiturlbasicsjava;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface PlaceholderService {

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);

    @GET("comments")
    Call<List<Comment>> getCommentsFromQuery(@Query("postId") int postId);

    @GET("comments")
    Call<List<Comment>> getSortedComments(
            @Query("postId") int postId,
            @Query("_sort") String sort,
            @Query("_order") String order);

    @GET("comments")
    Call<List<Comment>> getNullableComments(
            @Query("postId") Integer postId,
            @Query("_sort") String sort,
            @Query("_order") String order);

    @GET("comments")
    Call<List<Comment>> getSortedCommentsFromPosts(
            @Query("postId") Integer[] postsId,
            @Query("_sort") String sort,
            @Query("_order") String order);

    @GET("comments")
    Call<List<Comment>> getComments(
            @QueryMap Map<String, String> param
    );

    @GET
    Call<List<Comment>> getComments(
            @Url String url
    );
}
