package pl.udu.uwr.pum.retrofiturlbasicskotlin

import pl.udu.uwr.pum.retrofitpostbasicskotlin.Post
import retrofit2.Call
import retrofit2.http.*

interface PlaceholderService {
    @PUT("posts/{id}")
    fun putPost(@Path("id") postId: Int, @Body post: Post): Call<Post>

    @PATCH("posts/{id}")
    fun patchPost(@Path("id") postId: Int, @Body post: Post): Call<Post>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") postId: Int): Call<Void>
}
