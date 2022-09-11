package pl.udu.uwr.pum.retrofiturlbasicskotlin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface PlaceholderService {
    @GET("posts/{id}/comments")
    fun getComments(@Path("id") postId: Int): Call<List<Comment>>

    @GET("comments")
    fun getCommentsFromQuery(@Query("postId") postId: Int): Call<List<Comment>>

    @GET("comments")
    fun getSortedComments(
        @Query("postId") postId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Call<List<Comment>>

    @GET("comments")
    fun getNullableComments(
        @Query("postId") postId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Call<List<Comment>>

    @GET("comments")
    fun getSortedCommentsFromPosts(
        @Query("postId") postsId: List<Int>,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Call<List<Comment>>

    @GET("comments")
    fun getComments(
        @QueryMap param: Map<String, String>
    ): Call<List<Comment>>

    @GET
    fun getComments(
        @Url url: String
    ): Call<List<Comment>>
}
