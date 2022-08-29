package pl.udu.uwr.pum.notyjava.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.udu.uwr.pum.notyjava.R;
import pl.udu.uwr.pum.notyjava.adapters.NotyAdapter;
import pl.udu.uwr.pum.notyjava.databinding.FragmentNotesBinding;
import pl.udu.uwr.pum.notyjava.db.DBHandler;

public class NotesFragment extends Fragment {

    private FragmentNotesBinding binding;
    private DBHandler dbHandler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHandler = new DBHandler(requireContext());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotesBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(new NotyAdapter(dbHandler.getNotes()));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dbHandler.close();
    }
}