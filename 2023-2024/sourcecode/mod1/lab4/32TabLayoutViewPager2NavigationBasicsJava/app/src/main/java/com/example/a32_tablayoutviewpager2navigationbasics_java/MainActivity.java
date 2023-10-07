package com.example.a32_tablayoutviewpager2navigationbasics_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a32_tablayoutviewpager2navigationbasics_java.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewPager.setAdapter(new PagerAdapter(this));

        new TabLayoutMediator(binding.tabLayout, binding.viewPager,
                (tab, position) -> tab.setText("Fragment" + (position + 1))
        ).attach();
    }
}