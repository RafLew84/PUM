package com.example.repositorybasicsjava.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.repositorybasicsjava.R;
import com.example.repositorybasicsjava.databinding.FragmentUserBinding;
import com.example.repositorybasicsjava.viewmodel.UserViewModel;

import java.util.ArrayList;

public class UserFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        com.example.repositorybasicsjava.databinding.FragmentUserBinding binding = FragmentUserBinding.inflate(inflater);

        UserViewModel viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        UserAdapter userAdapter = new UserAdapter(new UserComparator());

        viewModel.getUsersList().observe(getViewLifecycleOwner(), users -> userAdapter.submitList(new ArrayList<>(users)));

        binding.rvList.setAdapter(userAdapter);
        binding.rvList.setLayoutManager(new LinearLayoutManager(requireContext()));

        return binding.getRoot();
    }
}