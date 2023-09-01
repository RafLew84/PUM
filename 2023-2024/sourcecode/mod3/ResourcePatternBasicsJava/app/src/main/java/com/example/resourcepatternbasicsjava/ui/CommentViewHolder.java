package com.example.resourcepatternbasicsjava.ui;

import androidx.recyclerview.widget.RecyclerView;

import com.example.resourcepatternbasicsjava.data.CommentResponseItem;
import com.example.resourcepatternbasicsjava.databinding.RvItemBinding;

public class CommentViewHolder extends RecyclerView.ViewHolder {
    private final RvItemBinding binding;

    public CommentViewHolder(RvItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(CommentResponseItem item) {
        binding.title.setText(item.getName());
        binding.body.setText(item.getBody());
        binding.commentId.setText(String.valueOf(item.getPostId()));
    }
}