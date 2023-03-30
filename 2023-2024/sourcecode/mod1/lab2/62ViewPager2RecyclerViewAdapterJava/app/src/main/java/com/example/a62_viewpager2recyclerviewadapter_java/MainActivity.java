package com.example.a62_viewpager2recyclerviewadapter_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a62_viewpager2recyclerviewadapter_java.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewPager.setAdapter(new PagerBasicAdapter());
    }
}