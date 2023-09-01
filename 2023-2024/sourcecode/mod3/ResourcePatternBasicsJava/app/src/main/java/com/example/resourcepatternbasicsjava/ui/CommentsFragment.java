package com.example.resourcepatternbasicsjava.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.resourcepatternbasicsjava.data.CommentResponseItem;
import com.example.resourcepatternbasicsjava.databinding.FragmentCommentsBinding;
import com.example.resourcepatternbasicsjava.util.Resource;
import com.example.resourcepatternbasicsjava.util.Status;
import com.example.resourcepatternbasicsjava.viewmodel.CommentsViewModel;

import java.util.List;

public class CommentsFragment extends Fragment {

    private FragmentCommentsBinding binding;
    private CommentsViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCommentsBinding.inflate(inflater, container, false);

        CommentAdapter commentAdapter = new CommentAdapter(new CommentComparator());
        viewModel = new ViewModelProvider(this).get(CommentsViewModel.class);

        viewModel.comments.observe(getViewLifecycleOwner(), response -> {
            if (response.status == Status.SUCCESS) {
                    List<CommentResponseItem> data = response.data;
                    if (data != null) {
                        commentAdapter.submitList(data);
                    }
                } else if (response.status == Status.ERROR) {
                    // Obsługa błędu
                } else if (response.status == Status.LOADING) {
                    // Obsługa stanu ładowania
                }
        });

//        getViewLifecycleOwner().getLifecycleScope().launch(() -> {
//            viewModel.getComments().collectLatest(response -> {
//                if (response instanceof Resource.Success) {
//                    List<CommentResponseItem> data = ((Resource.Success<List<CommentResponseItem>>) response).getData();
//                    if (data != null) {
//                        commentAdapter.submitList(data);
//                    }
//                } else if (response instanceof Resource.Error) {
//                    // Obsługa błędu
//                } else if (response instanceof Resource.Loading) {
//                    // Obsługa stanu ładowania
//                }
//            });
//        });

        binding.recycler.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recycler.setAdapter(commentAdapter);

        return binding.getRoot();
    }
}