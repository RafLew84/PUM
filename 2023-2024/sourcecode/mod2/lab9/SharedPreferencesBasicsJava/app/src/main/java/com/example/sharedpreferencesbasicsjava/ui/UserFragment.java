package com.example.sharedpreferencesbasicsjava.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sharedpreferencesbasicsjava.data.dummydata.DataProvider;
import com.example.sharedpreferencesbasicsjava.databinding.FragmentUserBinding;
import com.example.sharedpreferencesbasicsjava.viewmodel.UserViewModel;

public class UserFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final FragmentUserBinding binding = FragmentUserBinding.inflate(inflater);

        UserViewModel viewModel =new ViewModelProvider(this).get(UserViewModel.class);
        viewModel.getUsername().observe(requireActivity(), binding.textView::setText);

        binding.addButton.setOnClickListener(v -> viewModel.addUser(DataProvider.getUsername()));

        binding.clearButton.setOnClickListener(v -> viewModel.clearUsers());

        return binding.getRoot();
    }
}