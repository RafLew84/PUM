package com.example.a12_recyclerviewbasics_java;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a12_recyclerviewbasics_java.databinding.WordListItemBinding;

public class WordListViewHolder extends RecyclerView.ViewHolder {
    private final WordListItemBinding binding;
    public WordListViewHolder(WordListItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(String item){
        binding.singleWord.setText(item);
        binding.getRoot().setOnClickListener(view -> {
            String element = binding.singleWord.getText().toString();
            binding.singleWord.setText("Clicked" + element);
            binding.singleWord.setBackgroundColor(Color.CYAN);
        });
    }
}
