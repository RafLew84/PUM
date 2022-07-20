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
import android.widget.LinearLayout;

import pl.edu.uwr.pum.pumappjava.R;

public class StartFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = null;
        if (activity != null) {
            actionBar = activity.getSupportActionBar();
        }
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.app_name));
        }
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayout button = view.findViewById(R.id.start_button_layout);
        button.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(StartFragmentDirections.actionStartFragmentToModuleListFragment());
        });
    }
}