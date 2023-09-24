package com.example.retrofitbasicsjava.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.ListAdapter;

import com.example.retrofitbasicsjava.data.Post;
import com.example.retrofitbasicsjava.databinding.RvItemBinding;

public class PostAdapter extends ListAdapter<Post, PostViewHolder> {
    public PostAdapter(PostComparator postComparator) {
        super(postComparator);
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RvItemBinding binding = RvItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Post item = getItem(position);
        holder.bind(item);
    }
}