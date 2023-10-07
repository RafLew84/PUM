package com.example.a32_tablayoutviewpager2navigationbasics_java;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a32_tablayoutviewpager2navigationbasics_java.databinding.FragmentTemplateBinding;

public class TemplateFragment extends Fragment {

    private FragmentTemplateBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTemplateBinding.inflate(inflater);

        Bundle args = getArguments();
        if (args != null) {
            binding.textView.setText("Fragment " + args.getInt(PagerAdapter.arg));
        }

        return binding.getRoot();
    }
}