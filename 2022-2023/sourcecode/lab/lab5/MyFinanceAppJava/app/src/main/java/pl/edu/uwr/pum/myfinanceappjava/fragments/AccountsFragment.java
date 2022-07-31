package pl.edu.uwr.pum.myfinanceappjava.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.futured.donut.DonutProgressView;
import app.futured.donut.DonutSection;
import pl.edu.uwr.pum.myfinanceappjava.R;
import pl.edu.uwr.pum.myfinanceappjava.adapters.AccountAdapter;
import pl.edu.uwr.pum.myfinanceappjava.data.Account;
import pl.edu.uwr.pum.myfinanceappjava.data.DataProvider;
import pl.edu.uwr.pum.myfinanceappjava.util.FormatterUtil;


public class AccountsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new AccountAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        DonutProgressView donut = view.findViewById(R.id.donut_viewAccount);
        List<DonutSection> values = new ArrayList<>();
        for (Account item : DataProvider.accounts){
            values.add(
                    new DonutSection(
                            item.getName(),
                            item.getColor(),
                            ((float) item.getAmount() / (float) DataProvider.totalAccountsAmount))
            );
        }
        donut.submitData(values);

        TextView totalAmountTextView = view.findViewById(R.id.totalAmountTextView);
        totalAmountTextView.setText(String.format("%s zł", FormatterUtil.formatter.format(DataProvider.totalAccountsAmount)));
    }
}