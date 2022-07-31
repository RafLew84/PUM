package pl.edu.uwr.pum.myfinanceappjava.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import pl.edu.uwr.pum.myfinanceappjava.R;
import pl.edu.uwr.pum.myfinanceappjava.data.Bill;
import pl.edu.uwr.pum.myfinanceappjava.data.DataProvider;
import pl.edu.uwr.pum.myfinanceappjava.util.FormatterUtil;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recyclerview_item_view, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bill item = DataProvider.bills[position];
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return DataProvider.accounts.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameTextView;
        private final TextView endDateTextView;
        private final View colorBar;
        private final TextView amountTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.RVaccountNameTextView);
            endDateTextView = itemView.findViewById(R.id.RVaccountsNumberTextView);
            colorBar = itemView.findViewById(R.id.RVcolorBarView);
            amountTextView = itemView.findViewById(R.id.RVaccountValueTextView);
        }

        public void bind(Bill item){
            nameTextView.setText(item.getName());
            endDateTextView.setText(item.getDate().format(FormatterUtil.dateFormatter));
            amountTextView.setText(String.format("- %s zł", FormatterUtil.formatter.format(item.getAmount())));
            colorBar.setBackgroundColor(item.getColor());
        }
    }
}
