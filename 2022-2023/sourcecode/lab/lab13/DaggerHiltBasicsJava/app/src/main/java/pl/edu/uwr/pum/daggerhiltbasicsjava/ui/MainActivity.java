package pl.edu.uwr.pum.daggerhiltbasicsjava.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;
import pl.edu.uwr.pum.daggerhiltbasicsjava.R;
import pl.edu.uwr.pum.daggerhiltbasicsjava.data.Post;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        AppViewModel viewModel = new ViewModelProvider(this).get(AppViewModel.class);
        viewModel.getAllPosts();

        viewModel.getPosts().observe(this, posts -> {
            StringBuilder content = new StringBuilder();
            posts.forEach( post ->
                    content
                            .append("id: ").append(post.getId()).append("\n")
                            .append("UserId: ").append(post.getUserId()).append("\n")
                            .append("title: ").append(post.getTitle()).append("\n")
                            .append("body: ").append(post.getContent()).append("\n\n")
            );
            textView.setText(content.toString());
        });
    }
}