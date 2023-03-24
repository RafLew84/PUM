package com.example.a22counterjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a22counterjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

//    private TextView showCount;
//    private Button increaseButton;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        showCount = findViewById(R.id.show_count);
//        increaseButton = findViewById(R.id.increase_button);

        if (savedInstanceState != null)
            count = savedInstanceState.getInt("counter_state");

        binding.showCount.setText(String.valueOf(count));


        binding.increaseButton.setOnClickListener(view -> {
            count++;
            binding.showCount.setText(String.valueOf(count));
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("counter_state", count);
    }
}