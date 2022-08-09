package pl.udu.uwr.pum.carsyappjava.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.stream.Collectors;

import pl.udu.uwr.pum.carsyappjava.R;
import pl.udu.uwr.pum.carsyappjava.adapters.TimeLineAdapter;
import pl.udu.uwr.pum.carsyappjava.data.Car;
import pl.udu.uwr.pum.carsyappjava.data.DataProvider;


public class TimeLineFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_line, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.timeLineRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new TimeLineAdapter(requireContext(), DataProvider.getCars().get(0).getCosts()));

        Spinner spinner = view.findViewById(R.id.cars_spinner);
        spinner.setAdapter(new ArrayAdapter<>(getContext(), R.layout.spinner_layout,
                DataProvider.getCars().stream().map(Car::getName).collect(Collectors.toList())));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                recyclerView.swapAdapter(new TimeLineAdapter(getContext(), DataProvider.getCars().get(position).getCosts()), true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}