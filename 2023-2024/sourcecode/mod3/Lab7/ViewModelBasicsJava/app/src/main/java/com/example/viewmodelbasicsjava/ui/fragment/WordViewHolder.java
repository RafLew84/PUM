package com.example.viewmodelbasicsjava.ui.fragment;

import androidx.recyclerview.widget.RecyclerView;

import com.example.viewmodelbasicsjava.databinding.RvItemBinding;

public class WordViewHolder extends RecyclerView.ViewHolder {
    private final RvItemBinding binding;

    public WordViewHolder(RvItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(String item){
        binding.wordTextView.setText(item);
    }
}