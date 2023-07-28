package com.example.roombasicsjava.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.roombasicsjava.data.dummydata.DataProvider;
import com.example.roombasicsjava.databinding.FragmentUserBinding;
import com.example.roombasicsjava.viewmodel.UserViewModel;

import java.util.List;

public class UserFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        com.example.roombasicsjava.databinding.FragmentUserBinding binding = FragmentUserBinding.inflate(inflater);

        UserViewModel userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        final UserAdapter userAdapter = new UserAdapter(new UserComparator());
        binding.rvList.setAdapter(userAdapter);
        binding.rvList.setLayoutManager(new LinearLayoutManager(requireActivity()));
        userViewModel.getUsers().observe(requireActivity(), userAdapter::submitList);

        binding.addButton.setOnClickListener(v -> {userViewModel.addUser(DataProvider.getUser());});
        binding.clearButton.setOnClickListener(v -> userViewModel.clearUsers());


        return binding.getRoot();
    }
}
