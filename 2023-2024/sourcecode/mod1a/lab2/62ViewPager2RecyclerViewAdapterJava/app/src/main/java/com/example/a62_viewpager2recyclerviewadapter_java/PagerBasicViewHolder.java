package com.example.a62_viewpager2recyclerviewadapter_java;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a62_viewpager2recyclerviewadapter_java.databinding.PagerItemBinding;

public class PagerBasicViewHolder extends RecyclerView.ViewHolder {

    private PagerItemBinding binding;

    public PagerBasicViewHolder(PagerItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(String item){
        binding.textView.setText(item);
    }
}
