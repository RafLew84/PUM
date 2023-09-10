package com.example.a42_dynamicfragmentbasics_java;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a42_dynamicfragmentbasics_java.databinding.FragmentABinding;

public class FragmentA extends Fragment {

    private FragmentABinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentABinding.inflate(inflater);

        binding.startFragmentB
                .setOnClickListener(v -> requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container_view_tag, new FragmentB())
                        .addToBackStack(null)
                        .commit());

        return binding.getRoot();
    }
}