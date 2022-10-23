package pl.edu.uwr.pum.daggerhiltbasicsjava.ui;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import pl.edu.uwr.pum.daggerhiltbasicsjava.data.Post;
import pl.edu.uwr.pum.daggerhiltbasicsjava.data.repository.AppRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class AppViewModel extends ViewModel {
    private final MutableLiveData<List<Post>> posts = new MutableLiveData<>();
    private final AppRepository repository;

    @Inject
    public AppViewModel(AppRepository repository) {
        this.repository = repository;
    }

    public void getAllPosts(){
        Call<List<Post>> responseCall = repository.getPosts();

        responseCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                if (response.isSuccessful()){
                    List<Post> postsResponse = response.body();
                    if (postsResponse != null)
                        posts.postValue(postsResponse);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                Log.e("TAG", "error: " + t.getMessage());
            }
        });
    }

    public LiveData<List<Post>> getPosts() {
        return posts;
    }
}
