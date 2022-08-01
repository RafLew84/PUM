package pl.edu.uwr.pum.myfinanceappjava.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import pl.edu.uwr.pum.myfinanceappjava.R;
import pl.edu.uwr.pum.myfinanceappjava.adapters.AccountAdapter;
import pl.edu.uwr.pum.myfinanceappjava.adapters.BillAdapter;
import pl.edu.uwr.pum.myfinanceappjava.data.DataProvider;
import pl.edu.uwr.pum.myfinanceappjava.util.FormatterUtil;


public class OverviewFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_overview, container, false);
    }

    @SuppressLint("InflateParams")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView accountsRecyclerView = view.findViewById(R.id.accountsRecyclerView);
        accountsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        accountsRecyclerView.setAdapter(new AccountAdapter());

        RecyclerView billsRecyclerView = view.findViewById(R.id.billsRecyclerView);
        billsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        billsRecyclerView.setAdapter(new BillAdapter());

        TextView accountTotalAmountTextView = view.findViewById(R.id.accountTotalAmountTextView);
        accountTotalAmountTextView.setText(String.format("%s zł", FormatterUtil.formatter.format(DataProvider.totalAccountsAmount)));

        TextView billsTotalAmountTextView = view.findViewById(R.id.billsTotalAmountTextView);
        billsTotalAmountTextView.setText(String.format("%s zł", FormatterUtil.formatter.format(DataProvider.totalBillsAmount)));

        Button goToAccountsButton = view.findViewById(R.id.accountsButton);
        goToAccountsButton.setOnClickListener(v -> {
            ViewPager2 viewPager2 = requireActivity().findViewById(R.id.viewPager);
            viewPager2.setCurrentItem(1);
        });

        Button goToBillsButton = view.findViewById(R.id.billsButton);
        goToBillsButton.setOnClickListener(v -> {
            ViewPager2 viewPager2 = requireActivity().findViewById(R.id.viewPager);
            viewPager2.setCurrentItem(2);
        });

        Button seeMoreButton = view.findViewById(R.id.seeMoreButton);
        seeMoreButton.setOnClickListener(v -> {
            new AlertDialog.Builder(getContext(), R.style.MyDialogTheme)
                    .setTitle(getString(R.string.alerts))
                    .setView(getLayoutInflater().inflate(R.layout.alert_dialog, null))
                    .setPositiveButton("OK", (dialogInterface, i) -> {})
                    .create()
                    .show();
        });
    }
}