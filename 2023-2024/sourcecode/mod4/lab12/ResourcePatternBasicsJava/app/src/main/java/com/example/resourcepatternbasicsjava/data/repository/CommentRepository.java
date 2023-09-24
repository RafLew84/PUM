package com.example.resourcepatternbasicsjava.data.repository;


import com.example.resourcepatternbasicsjava.data.CommentResponseItem;
import com.example.resourcepatternbasicsjava.data.api.PlaceholderApi;
import com.example.resourcepatternbasicsjava.data.api.RetrofitInstance;

import java.util.List;

import retrofit2.Call;

public class CommentRepository {
    private final PlaceholderApi api = RetrofitInstance.getApi();

    public Call<List<CommentResponseItem>> getComments() {
        return api.comments();
    }
}
