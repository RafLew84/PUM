package com.example.a32_staticfragmentbasics_java;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a32_staticfragmentbasics_java.databinding.FragmentABinding;
import com.example.a32_staticfragmentbasics_java.databinding.FragmentBBinding;

public class FragmentB extends Fragment {

    private FragmentBBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBBinding.inflate(inflater);
        return binding.getRoot();
    }
}