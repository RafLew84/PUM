package com.example.resourcepatternbasicsjava.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.resourcepatternbasicsjava.data.CommentResponseItem;
import com.example.resourcepatternbasicsjava.data.repository.CommentRepository;
import com.example.resourcepatternbasicsjava.util.Resource;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsViewModel extends ViewModel {

    private final CommentRepository repository = new CommentRepository();
    private final MutableLiveData<Resource<List<CommentResponseItem>>> _comments = new MutableLiveData<>();
    public LiveData<Resource<List<CommentResponseItem>>> comments = _comments;

    public CommentsViewModel() {
        try {
            getPosts();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getPosts() throws IOException {
        Call<List<CommentResponseItem>> response = repository.getComments();

        response.enqueue(new Callback<List<CommentResponseItem>>() {
            @Override
            public void onResponse(@NonNull Call<List<CommentResponseItem>> call, @NonNull Response<List<CommentResponseItem>> response) {
                if (response.isSuccessful()){
                    _comments.postValue(Resource.loading(null));
                    List<CommentResponseItem> postsResponse = response.body();
                    if (postsResponse != null)
                        _comments.postValue(Resource.success(postsResponse));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<CommentResponseItem>> call, @NonNull Throwable t) {
                _comments.postValue(Resource.error(t.getLocalizedMessage(), null));
            }
        });
    }
}
