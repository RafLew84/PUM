package com.example.retrofitbasicsjava.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.retrofitbasicsjava.R;
import com.example.retrofitbasicsjava.databinding.FragmentPostBinding;
import com.example.retrofitbasicsjava.viewmodel.PostViewModel;

public class PostFragment extends Fragment {
    private FragmentPostBinding binding;
    private PostViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPostBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        viewModel = new ViewModelProvider(this).get(PostViewModel.class);

        PostAdapter postAdapter = new PostAdapter(new PostComparator());

        viewModel.posts.observe(getViewLifecycleOwner(), postAdapter::submitList);

        binding.recycler.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recycler.setAdapter(postAdapter);

        return rootView;
    }
}