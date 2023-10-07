package com.example.a12_jetpacknavigationbasics_java;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a12_jetpacknavigationbasics_java.databinding.FragmentBBinding;

public class FragmentB extends Fragment {

    private FragmentBBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBBinding.inflate(inflater);

        binding.textView.setText(String.valueOf(
                getArguments() != null ? getArguments().getInt("value") : 0
        ));

        binding.fabB.setOnClickListener(v -> {
            NavDirections action = FragmentBDirections.actionFragmentBToFragmentA();
            Navigation.findNavController(requireView()).navigate(action);


        });

        return binding.getRoot();
    }
}