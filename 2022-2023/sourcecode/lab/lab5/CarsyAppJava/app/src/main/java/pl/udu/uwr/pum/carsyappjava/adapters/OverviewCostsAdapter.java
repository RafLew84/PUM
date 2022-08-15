package pl.udu.uwr.pum.carsyappjava.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.stream.Collectors;

import pl.udu.uwr.pum.carsyappjava.R;
import pl.udu.uwr.pum.carsyappjava.data.Car;
import pl.udu.uwr.pum.carsyappjava.data.Cost;
import pl.udu.uwr.pum.carsyappjava.data.CostType;
import pl.udu.uwr.pum.carsyappjava.data.DataProvider;
import pl.udu.uwr.pum.carsyappjava.util.FormatterUtil;

public class OverviewCostsAdapter extends RecyclerView.Adapter<OverviewCostsAdapter.ViewHolder> {

    private final ArrayList<Car> cars = DataProvider.getCars();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView carNameTextView;
        private final TextView refuelingTextView;
        private final TextView serviceTextView;
        private final TextView parkingTextView;
        private final TextView insuranceTextView;
        private final TextView ticketTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            carNameTextView = itemView.findViewById(R.id.overviewRecyclerViewCarName);
            refuelingTextView = itemView.findViewById(R.id.overviewRecyclerViewFueling);
            serviceTextView = itemView.findViewById(R.id.overviewRecyclerViewService);
            parkingTextView = itemView.findViewById(R.id.overviewRecyclerViewParking);
            insuranceTextView = itemView.findViewById(R.id.overviewRecyclerViewInsurance);
            ticketTextView = itemView.findViewById(R.id.overviewRecyclerViewTicket);
        }

        public void bind (Car item){
            carNameTextView.setText(item.getName());
            refuelingTextView.setText(costValue(item, CostType.REFUELING));
            serviceTextView.setText(costValue(item, CostType.SERVICE));
            parkingTextView.setText(costValue(item, CostType.PARKING));
            insuranceTextView.setText(costValue(item, CostType.INSURANCE));
            ticketTextView.setText(costValue(item, CostType.TICKET));
        }

        private String costValue(Car item, CostType costType){
            return FormatterUtil.decimalFormat.format(
                    item.getCosts().stream()
                            .filter(i-> i.getType() == costType)
                            .map(Cost::getAmount)
                            .reduce(0, Integer::sum)
            ) + " zł";
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_recyclerview_cost_overview, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Car item = cars.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
