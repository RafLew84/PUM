package pl.edu.uwr.pum.myfinanceappjava.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import pl.edu.uwr.pum.myfinanceappjava.R;
import pl.edu.uwr.pum.myfinanceappjava.data.Accounts;
import pl.edu.uwr.pum.myfinanceappjava.data.DataProvider;
import pl.edu.uwr.pum.myfinanceappjava.util.FormatterUtil;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.accounts_item_view, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Accounts item = DataProvider.accounts[position];
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return DataProvider.accounts.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameTextView;
        private final TextView accountNumberTextView;
        private final View colorBar;
        private final TextView amountTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.RVaccountNameTextView);
            accountNumberTextView = itemView.findViewById(R.id.RVaccountsNumberTextView);
            colorBar = itemView.findViewById(R.id.RVcolorBarView);
            amountTextView = itemView.findViewById(R.id.RVaccountValueTextView);
        }

        public void bind(Accounts item){
            nameTextView.setText(item.getName());
            accountNumberTextView.setText(new StringBuilder(item.getNumber()).replace(0, 6, "******").toString());
            amountTextView.setText(String.format("%s zł", FormatterUtil.formatter.format(item.getAmount())));
            colorBar.setBackgroundColor(item.getColor());
        }
    }
}
