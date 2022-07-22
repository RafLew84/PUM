package pl.edu.uwr.pum.pumappjava.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pl.edu.uwr.pum.pumappjava.R;
import pl.edu.uwr.pum.pumappjava.data.DataProvider;
import pl.edu.uwr.pum.pumappjava.data.Module;


public class ModuleFragment extends Fragment {

    private Module module;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int moduleId;
        if (getArguments() != null) {
            moduleId = getArguments().getInt("moduleId");
        } else{
            throw new IllegalArgumentException("Wrong moduleId");
        }

        module = DataProvider.getModules().get(moduleId);
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
            actionBar.setTitle(module.getName());
        }
        return inflater.inflate(R.layout.fragment_module, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button lectureButton = view.findViewById(R.id.lectureButton);
        Button labButton = view.findViewById(R.id.labButton);
        Button appButton = view.findViewById(R.id.appButton);

        lectureButton.setText(String.format("Wykład: \n%s", module.getLecture().getName()));
        labButton.setText(String.format("Laboratorium: \n%s", module.getLab().getName()));
        appButton.setText(R.string.applications);

        lectureButton.setOnClickListener(v -> Navigation.findNavController(v).navigate(ModuleFragmentDirections.actionModuleFragmentToLectureFragment(module.getId())));
        labButton.setOnClickListener(v -> Navigation.findNavController(v).navigate(ModuleFragmentDirections.actionModuleFragmentToLabListFragment(module.getId())));
        appButton.setOnClickListener(v -> Navigation.findNavController(v).navigate(ModuleFragmentDirections.actionModuleFragmentToAppListFragment(module.getId())));
    }
}