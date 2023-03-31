package com.example.a12_jetpacknavigationbasics_java;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a12_jetpacknavigationbasics_java.databinding.FragmentABinding;

public class FragmentA extends Fragment {

    private FragmentABinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentABinding.inflate(inflater);

        binding.fabA.setOnClickListener(view -> {
            NavDirections action = FragmentADirections.actionFragmentAToFragmentB(5);
            Navigation.findNavController(requireView()).navigate(action);

//            Bundle args = new Bundle();
//            args.putInt("key", 5);
//            Navigation.findNavController(requireView()).navigate(R.id.fragmentB, args);
        });

        return binding.getRoot();
    }
}