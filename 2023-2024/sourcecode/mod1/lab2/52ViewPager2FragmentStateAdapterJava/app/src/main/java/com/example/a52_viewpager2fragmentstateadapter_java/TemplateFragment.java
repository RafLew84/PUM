package com.example.a52_viewpager2fragmentstateadapter_java;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a52_viewpager2fragmentstateadapter_java.databinding.FragmentTemplateBinding;

public class TemplateFragment extends Fragment {

    private FragmentTemplateBinding binding;
    private int position;

    public TemplateFragment(int position) {
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTemplateBinding.inflate(inflater);

        binding.textView.setText("Fragment " + String.valueOf(position + 1));

        return binding.getRoot();
    }
}