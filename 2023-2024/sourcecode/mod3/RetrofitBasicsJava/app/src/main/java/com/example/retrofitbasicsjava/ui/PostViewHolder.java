package com.example.retrofitbasicsjava.ui;

import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitbasicsjava.data.Post;
import com.example.retrofitbasicsjava.databinding.RvItemBinding;

public class PostViewHolder extends RecyclerView.ViewHolder {
    private final RvItemBinding binding;

    public PostViewHolder(RvItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Post item) {
        binding.title.setText(item.getTitle());
        binding.content.setText(item.getContent());
        binding.userId.setText(String.valueOf(item.getUserId()));
    }
}
