package com.example.a62_viewpager2recyclerviewadapter_java;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a62_viewpager2recyclerviewadapter_java.databinding.PagerItemBinding;

public class PagerBasicAdapter extends RecyclerView.Adapter<PagerBasicViewHolder> {
    @NonNull
    @Override
    public PagerBasicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PagerBasicViewHolder(PagerItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull PagerBasicViewHolder holder, int position) {
        holder.bind(DataProvider.values[position]);
    }

    @Override
    public int getItemCount() {
        return DataProvider.values.length;
    }
}
