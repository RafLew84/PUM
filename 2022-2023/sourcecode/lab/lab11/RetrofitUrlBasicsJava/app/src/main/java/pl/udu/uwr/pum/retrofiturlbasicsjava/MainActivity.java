package pl.udu.uwr.pum.retrofiturlbasicsjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> param = new HashMap<>();
        param.put("postId", "1");
        param.put("_sort", "id");
        param.put("_order", "desc");

        TextView textView = findViewById(R.id.textView);

        PlaceholderService service = RetrofitFactory.makeService();

        Call<List<Comment>> call = service.getComments("comments?postId=3");

        call.enqueue(new Callback<List<Comment>>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<List<Comment>> call, @NonNull Response<List<Comment>> response) {
                if (response.isSuccessful()){
                    List<Comment> comments = response.body();
                    if (comments != null) {
                        comments.forEach(comment -> {
                            StringBuilder content = new StringBuilder();
                            content.append("id: ").append(comment.getId()).append("\n")
                                    .append("PostId: ").append(comment.getPostId()).append("\n")
                                    .append("name: ").append(comment.getName()).append("\n")
                                    .append("email: ").append(comment.getEmail()).append("\n")
                                    .append("text: ").append(comment.getText()).append("\n\n");
                            textView.append(content);
                        });
                    }
                } else
                    textView.setText("Code: " + response.code());
            }

            @Override
            public void onFailure(@NonNull Call<List<Comment>> call, @NonNull Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
}