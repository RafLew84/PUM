package pl.udu.uwr.pum.retrofiturlbasicskotlin

import pl.udu.uwr.pum.retrofitpostbasicskotlin.Post
import retrofit2.Call
import retrofit2.http.*

interface PlaceholderService {
    @POST("posts")
    fun createPost(@Body post: Post): Call<Post>

    @FormUrlEncoded
    @POST("posts")
    fun createPost(
        @Field("userId") userId: Int,
        @Field("title") title: String,
        @Field("body") text: String
    ): Call<Post?>?

    @FormUrlEncoded
    @POST("posts")
    fun createPost(
        @FieldMap param: Map<String, String>
    ): Call<Post>
}
