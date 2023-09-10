package com.example.retrofitbasicsjava.data.api;

import com.example.retrofitbasicsjava.data.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlaceholderApi {
    @GET("posts")
    Call<List<Post>> posts();
}
