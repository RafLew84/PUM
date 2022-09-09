package pl.udu.uwr.pum.retrofitbasicsjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlaceholderApi api = retrofit.create(PlaceholderApi.class);

        Call<List<Post>> call = api.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    List<Post> posts = response.body();
                    if (posts != null) {
                        posts.forEach(post -> {
                            StringBuilder content = new StringBuilder();
                            content.append("id: ").append(post.getId()).append("\n")
                                    .append("UserId: ").append(post.getUserId()).append("\n")
                                    .append("title: ").append(post.getTitle()).append("\n")
                                    .append("body: ").append(post.getContent()).append("\n\n");
                            textView.append(content);
                        });
                    }
                } else {
                    textView.setText(String.format("Code: %d", response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
}