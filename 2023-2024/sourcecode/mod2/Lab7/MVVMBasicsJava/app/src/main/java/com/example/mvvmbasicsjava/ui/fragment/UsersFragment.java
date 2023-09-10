package com.example.mvvmbasicsjava.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mvvmbasicsjava.databinding.FragmentUsersBinding;
import com.example.mvvmbasicsjava.model.User;
import com.example.mvvmbasicsjava.viewmodel.UserViewModel;

import java.util.ArrayList;

public class UsersFragment extends Fragment {

    private FragmentUsersBinding binding;

    private UserViewModel viewModel;
    private UserAdapter userAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentUsersBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userAdapter = new UserAdapter(new UserComparator());

        viewModel.getUsersList().observe(getViewLifecycleOwner(), users -> userAdapter.submitList(new ArrayList<>(users)));

        binding.rvList.setAdapter(userAdapter);
        binding.rvList.setLayoutManager(new LinearLayoutManager(requireContext()));

        binding.addButton.setOnClickListener(v -> onAddUser());
        binding.resetButton.setOnClickListener(v -> onResetUsers());
        binding.clearButton.setOnClickListener(v -> onClearUsers());

        return binding.getRoot();
    }

    private void onAddUser() {
        if (binding.firstNameEditText.getText() != null && binding.lastNameEditText.getText() != null) {
            String firstName = binding.firstNameEditText.getText().toString().trim();
            String lastName = binding.lastNameEditText.getText().toString().trim();

            if (!firstName.isEmpty() && !lastName.isEmpty()) {
                User newUser = new User(firstName, lastName);
                viewModel.addUser(newUser);

                binding.firstNameEditText.getText().clear();
                binding.lastNameEditText.getText().clear();
            }
        }
    }

    private void onResetUsers() {
        viewModel.reinitialize();
    }

    private void onClearUsers() {
        viewModel.clear();
    }
}
