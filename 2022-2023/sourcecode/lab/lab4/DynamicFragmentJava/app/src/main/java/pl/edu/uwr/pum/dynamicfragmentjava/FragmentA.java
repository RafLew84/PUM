package pl.edu.uwr.pum.dynamicfragmentjava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_a, container, false);
        view.findViewById(R.id.start_fragment_b)
                .setOnClickListener(v -> requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container_view_tag, new FragmentB())
                        .addToBackStack(null)
                        .commit());
        return view;
    }
}
