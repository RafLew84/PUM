package pl.edu.uwr.pum.pumappjava.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.edu.uwr.pum.pumappjava.R;
import pl.edu.uwr.pum.pumappjava.adapters.ContentAdapter;
import pl.edu.uwr.pum.pumappjava.data.DataProvider;

public class LabListFragment extends Fragment {
    private String labName;
    private int moduleId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            moduleId = getArguments().getInt("moduleId");
        } else{
            throw new IllegalArgumentException("Wrong moduleId");
        }

        labName = DataProvider.getModules().get(moduleId).getLab().getName();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = null;
        if (activity != null) {
            actionBar = activity.getSupportActionBar();
        }
        if (actionBar != null) {
            actionBar.setTitle(labName);
        }
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.contentRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new ContentAdapter(DataProvider.getModules().get(moduleId).getLab().getContent()));
    }
}