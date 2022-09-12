package pl.udu.uwr.pum.retrofitputpatchdeletebasicsjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        PlaceholderService service = RetrofitFactory.makeService();
        Call<Post> callPut = service.putPost(101, new Post(1, null, "content"));

        callPut.enqueue(new Callback<Post>() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                if (response.isSuccessful()) {
                    Post post = response.body();

                    StringBuilder content = new StringBuilder();
                    if (post != null) {
                        content.append("code: ").append(response.code()).append("\n")
                                .append("id: ").append(post.getId()).append("\n")
                                .append("UserId: ").append(post.getUserId()).append("\n")
                                .append("title: ").append(post.getTitle()).append("\n")
                                .append("body: ").append(post.getContent()).append("\n\n");
                    }
                    textView.append(content);
                } else {
                    textView.setText(String.format("Code: %d", response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
                textView.setText(t.getMessage());
            }
        });

        Call<Post> callPatch = service.patchPost(1, new Post(300, null, "content"));

        callPatch.enqueue(new Callback<Post>() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                if (response.isSuccessful()) {
                    Post post = response.body();

                    StringBuilder content = new StringBuilder();
                    if (post != null) {
                        content.append("code: ").append(response.code()).append("\n")
                                .append("id: ").append(post.getId()).append("\n")
                                .append("UserId: ").append(post.getUserId()).append("\n")
                                .append("title: ").append(post.getTitle()).append("\n")
                                .append("body: ").append(post.getContent()).append("\n\n");
                    }
                    textView.append(content);
                } else {
                    textView.setText(String.format("Code: %d", response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
                textView.setText(t.getMessage());
            }
        });

    }
}