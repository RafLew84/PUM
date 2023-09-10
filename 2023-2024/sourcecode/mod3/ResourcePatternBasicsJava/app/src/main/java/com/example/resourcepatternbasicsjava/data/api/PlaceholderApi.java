package com.example.resourcepatternbasicsjava.data.api;

import com.example.resourcepatternbasicsjava.data.CommentResponseItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlaceholderApi {
    @GET("comments")
    Call<List<CommentResponseItem>> comments();
}
