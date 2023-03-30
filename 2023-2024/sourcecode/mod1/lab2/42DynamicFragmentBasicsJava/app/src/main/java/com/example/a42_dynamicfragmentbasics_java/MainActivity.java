package com.example.a42_dynamicfragmentbasics_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a42_dynamicfragmentbasics_java.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container_view_tag, new MainFragment())
                .commit();
    }
}