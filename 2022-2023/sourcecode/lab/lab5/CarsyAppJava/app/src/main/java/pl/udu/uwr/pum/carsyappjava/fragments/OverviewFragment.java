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
import android.widget.TextView;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.Collections;

import pl.udu.uwr.pum.carsyappjava.R;
import pl.udu.uwr.pum.carsyappjava.adapters.OverviewCarsAdapter;
import pl.udu.uwr.pum.carsyappjava.adapters.OverviewCostsAdapter;
import pl.udu.uwr.pum.carsyappjava.data.Car;
import pl.udu.uwr.pum.carsyappjava.data.Cost;
import pl.udu.uwr.pum.carsyappjava.data.CostType;
import pl.udu.uwr.pum.carsyappjava.data.DataProvider;
import pl.udu.uwr.pum.carsyappjava.util.FormatterUtil;


public class OverviewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_overview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView costsRecyclerView = view.findViewById(R.id.overviewCostsRecyclerView);
        costsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        costsRecyclerView.setAdapter(new OverviewCostsAdapter());

        RecyclerView carsRecyclerView = view.findViewById(R.id.overviewCarsRecyclerView);
        carsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        carsRecyclerView.setAdapter(new OverviewCarsAdapter());

        TextView refuelingTextView = view.findViewById(R.id.overviewFueling);
        refuelingTextView.setText(FormatterUtil.decimalFormat.format(totalValue(CostType.REFUELING)));

        TextView serviceTextView = view.findViewById(R.id.overviewService);
        serviceTextView.setText(FormatterUtil.decimalFormat.format(totalValue(CostType.SERVICE)));

        TextView parkingTextView = view.findViewById(R.id.overviewParking);
        parkingTextView.setText(FormatterUtil.decimalFormat.format(totalValue(CostType.PARKING)));

        TextView insuranceTextView = view.findViewById(R.id.overviewInsurance);
        insuranceTextView.setText(FormatterUtil.decimalFormat.format(totalValue(CostType.INSURANCE)));

        TextView ticketTextView = view.findViewById(R.id.overviewTicket);
        ticketTextView.setText(FormatterUtil.decimalFormat.format(totalValue(CostType.TICKET)));

    }

    private int totalValue(CostType costType){
        return  DataProvider.getCars().stream()
                .flatMap(list -> list.getCosts().stream())
                .filter(i-> i.getType() == costType)
                .map(Cost::getAmount)
                .reduce(0, Integer::sum);
    }
}