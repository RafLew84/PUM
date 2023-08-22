package com.example.viewmodelbasicsjava.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewmodelbasicsjava.R;
import com.example.viewmodelbasicsjava.databinding.FragmentListBinding;
import com.example.viewmodelbasicsjava.viewmodel.WordViewModel;

public class ListFragment extends Fragment {

    private FragmentListBinding binding;

    private WordViewModel viewModel;
    private WordAdapter wordAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater);

        viewModel = new ViewModelProvider(requireActivity()).get(WordViewModel.class);
        wordAdapter = new WordAdapter(new WordComparator());
        wordAdapter.submitList(viewModel.getWordList());

        binding.rvList.setAdapter(wordAdapter);
        binding.rvList.setLayoutManager(new LinearLayoutManager(requireActivity()));

        binding.addButton.setOnClickListener(view -> onAddWord());
        binding.resetButton.setOnClickListener(view -> onResetWords());
        binding.clearButton.setOnClickListener(view -> onClearWords());

        return binding.getRoot();
    }

    private void onAddWord() {
        String word = binding.wordEditText.getText().toString();
        viewModel.addWord(word);
        wordAdapter.notifyDataSetChanged();
    }

    private void onResetWords(){
        viewModel.reinitialize();
        wordAdapter.notifyDataSetChanged();
    }

    private void onClearWords(){
        viewModel.clear();
        wordAdapter.notifyDataSetChanged();
    }
}