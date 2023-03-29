package com.example.a12_recyclerviewbasics_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.a12_recyclerviewbasics_java.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private final ArrayList<String> wordList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        for (int i = 0; i < 30; i++)
            wordList.add("Word" + i);

        binding.recyclerView.setAdapter(new WordListAdapter(wordList));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}