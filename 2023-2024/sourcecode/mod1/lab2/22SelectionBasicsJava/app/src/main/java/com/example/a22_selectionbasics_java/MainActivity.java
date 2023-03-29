package com.example.a22_selectionbasics_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.selection.SelectionPredicates;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StableIdKeyProvider;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.a22_selectionbasics_java.databinding.ActivityMainBinding;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NumberListAdapter numberListAdapter = new NumberListAdapter(createList());
        binding.recyclerView.setAdapter(numberListAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SelectionTracker<Long> selectionTracker = new SelectionTracker.Builder<>(
                "numberSelection",
                binding.recyclerView,
                new StableIdKeyProvider(binding.recyclerView),
                new NumberItemDetailsLookup(binding.recyclerView),
                StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
                SelectionPredicates.createSelectAnything()
        ).build();
        numberListAdapter.setSelectionTracker(selectionTracker);
    }

    private LinkedList<Integer> createList(){
        LinkedList<Integer> numbers = new LinkedList<>();
        for(int i = 0; i < 50; i++)
            numbers.add(i);
        return  numbers;
    }
}