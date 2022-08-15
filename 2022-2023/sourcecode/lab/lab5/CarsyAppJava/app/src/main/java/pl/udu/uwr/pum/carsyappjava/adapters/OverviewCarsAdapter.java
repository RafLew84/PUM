package pl.udu.uwr.pum.carsyappjava.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pl.udu.uwr.pum.carsyappjava.R;
import pl.udu.uwr.pum.carsyappjava.data.Car;
import pl.udu.uwr.pum.carsyappjava.data.Cost;
import pl.udu.uwr.pum.carsyappjava.data.DataProvider;
import pl.udu.uwr.pum.carsyappjava.util.FormatterUtil;

public class OverviewCarsAdapter extends RecyclerView.Adapter<OverviewCarsAdapter.ViewHolder> {

    private final ArrayList<Car> cars = DataProvider.getCars();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView carNameTextView;
        private final TextView brandTextView;
        private final TextView modelTextView;
        private final TextView yearTextView;
        private final TextView totalCostsTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            carNameTextView= itemView.findViewById(R.id.overviewViewPagerCarName);
            brandTextView = itemView.findViewById(R.id.overviewViewPagerBrand);
            modelTextView = itemView.findViewById(R.id.overviewViewPagerModel);
            yearTextView = itemView.findViewById(R.id.overviewViewPagerYearOfProduction);
            totalCostsTextView = itemView.findViewById(R.id.overviewViewPagerTotalCosts);
        }

        public void bind (Car item){
            carNameTextView.setText(item.getName());
            brandTextView.setText(item.getBrand());
            modelTextView.setText(item.getModel());
            yearTextView.setText(item.getYearOfProduction());
            totalCostsTextView.setText(String.format("%s zł",
                    FormatterUtil.decimalFormat.format(
                            item.getCosts().stream()
                                    .map(Cost::getAmount)
                                    .reduce(0, Integer::sum))));
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_recyclerview_cars_overview, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Car item = cars.get(position);
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
