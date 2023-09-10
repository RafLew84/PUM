package com.example.livedatabasics_java.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.livedatabasics_java.R;
import com.example.livedatabasics_java.databinding.FragmentCounterBinding;
import com.example.livedatabasics_java.viewmodel.CounterViewModel;

public class CounterFragment extends Fragment {

    private FragmentCounterBinding binding;

    private CounterViewModel viewModel;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCounterBinding.inflate(inflater);

        viewModel = new ViewModelProvider(requireActivity()).get(CounterViewModel.class);

        viewModel.getCounter().observe(getViewLifecycleOwner(),
                newValue -> binding.showCount.setText(newValue.toString()));

        binding.increaseButton.setOnClickListener(view -> viewModel.increase());
        binding.decreaseButton.setOnClickListener( view -> viewModel.decrease());
        binding.resetButtton.setOnClickListener (view -> viewModel.clear());

        return binding.getRoot();
    }
}