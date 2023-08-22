package com.example.retrofitbasicsjava.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofitbasicsjava.data.Post;
import com.example.retrofitbasicsjava.data.repository.PostRepository;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    private final PostRepository repository = new PostRepository();
    private final MutableLiveData<List<Post>> _posts = new MutableLiveData<>();
    public LiveData<List<Post>> posts = _posts;

    public PostViewModel() {
        try {
            getPosts();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getPosts() throws IOException {
        Call<List<Post>> response = repository.getPosts();

        response.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                if (response.isSuccessful()){
                    List<Post> postsResponse = response.body();
                    if (postsResponse != null)
                        _posts.postValue(postsResponse);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {

            }
        });
    }
}
