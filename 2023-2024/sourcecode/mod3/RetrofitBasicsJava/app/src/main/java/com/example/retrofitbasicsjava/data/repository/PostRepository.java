package com.example.retrofitbasicsjava.data.repository;

import com.example.retrofitbasicsjava.data.Post;
import com.example.retrofitbasicsjava.data.api.PlaceholderApi;
import com.example.retrofitbasicsjava.data.api.RetrofitInstance;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

public class PostRepository {
    private final PlaceholderApi api = RetrofitInstance.getApi();

    public Call<List<Post>> getPosts() throws IOException {
        return api.posts();
    }
}
