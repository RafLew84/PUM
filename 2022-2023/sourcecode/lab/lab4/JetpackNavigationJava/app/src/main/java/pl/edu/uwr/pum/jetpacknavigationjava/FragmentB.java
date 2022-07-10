package pl.edu.uwr.pum.jetpacknavigationjava;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        TextView textView = view.findViewById(R.id.textViewB);
        textView.setText(String.valueOf(
                getArguments() != null ? getArguments().getInt("key") : 0
        ));

        view.findViewById(R.id.fabB).setOnClickListener(v ->{
            NavDirections action = FragmentBDirections.toFragmentA();
            Navigation.findNavController(view).navigate(action);
        });

        return view;
    }
}