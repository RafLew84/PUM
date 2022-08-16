package pl.edu.uwr.pum.viewbindingjava;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.edu.uwr.pum.viewbindingjava.databinding.FragmentABinding;

public class FragmentA extends Fragment {

    private FragmentABinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentABinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.textviewFragment.setText("HELLO");
        binding.buttonFragment.setOnClickListener(v -> {
            binding.textviewFragment.setText("Click!!!");
        });
    }
}