package pl.edu.uwr.pum.jetpacknavigationjava;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentA extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        view.findViewById(R.id.fabA).setOnClickListener(v ->{
            //NavDirections action = FragmentADirections.toFragmentB();

            Bundle args = new Bundle();
            args.putInt("key", 5);
            Navigation.findNavController(view).navigate(R.id.to_fragmentB, args);
        });

        return view;
    }
}