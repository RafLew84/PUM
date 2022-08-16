package pl.edu.uwr.pum.viewbindingjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import pl.edu.uwr.pum.viewbindingjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textview.setText("HELLO");
        binding.button.setOnClickListener(view -> {
            binding.textview.setText("Click!!!");
        });
    }
}