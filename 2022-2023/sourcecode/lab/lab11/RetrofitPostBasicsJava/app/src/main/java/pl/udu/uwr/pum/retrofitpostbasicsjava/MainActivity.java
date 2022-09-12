package pl.udu.uwr.pum.retrofitpostbasicsjava;

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

        PlaceholderService service = RetrofitFactory.makeService();
        Call<Post> call = service.createPost(new Post(200, "nowy", "nowy post"));

        call.enqueue(new Callback<Post>() {
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