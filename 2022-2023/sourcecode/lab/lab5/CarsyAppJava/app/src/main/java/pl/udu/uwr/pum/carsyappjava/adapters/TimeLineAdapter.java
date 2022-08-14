package pl.udu.uwr.pum.carsyappjava.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

import pl.udu.uwr.pum.carsyappjava.R;
import pl.udu.uwr.pum.carsyappjava.data.Cost;
import pl.udu.uwr.pum.carsyappjava.data.CostDateItem;
import pl.udu.uwr.pum.carsyappjava.data.CostGeneralItem;
import pl.udu.uwr.pum.carsyappjava.data.CostListItem;
import pl.udu.uwr.pum.carsyappjava.data.DataProvider;
import pl.udu.uwr.pum.carsyappjava.util.FormatterUtil;

public class TimeLineAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final ArrayList<CostListItem> itemList;

    public TimeLineAdapter(Context context, ArrayList<Cost> costs){
        this.context = context;
        this.itemList = DataProvider.getTimeLineList(costs);
        Collections.reverse(itemList);
    }

    static class DateViewHolder extends RecyclerView.ViewHolder{

        private final TextView dateTextView;

        public DateViewHolder(@NonNull View itemView) {
            super(itemView);

            dateTextView = itemView.findViewById(R.id.timeLineDateTextView);
        }

        public void bind(CostDateItem item){
            dateTextView.setText(item.getDate());
        }
    }

    class GeneralViewHolder extends RecyclerView.ViewHolder{

        private final TextView costTypeTextView;
        private final TextView fullDateTextView;
        private final TextView amountTextView;
        private final ImageView iconImageView;

        public GeneralViewHolder(@NonNull View itemView) {
            super(itemView);

            costTypeTextView = itemView.findViewById(R.id.timeLineCostTypeNameTextView);
            fullDateTextView = itemView.findViewById(R.id.timeLineFullDateTextView);
            amountTextView = itemView.findViewById(R.id.timeLineCostAmountTextView);
            iconImageView = itemView.findViewById(R.id.iconTimeLineImageView);
        }

        public void bind(CostGeneralItem item){
            costTypeTextView.setText(item.getCost().getType().getCostType());
            fullDateTextView.setText(item.getCost().getDate().format(FormatterUtil.dateFormatter));
            amountTextView.setText(item.getCost().getAmount());
            iconImageView.setBackground(ContextCompat.getDrawable(context, item.getCost().getType().getIcon()));
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType){
            case CostListItem.TYPE_DATE:
                View dateView = inflater.inflate(R.layout.date_item_timeline, parent, false);
                viewHolder = new DateViewHolder(dateView);
                break;
            case CostListItem.TYPE_GENERAL:
                View generalView = inflater.inflate(R.layout.general_item_timeline, parent, false);
                viewHolder = new GeneralViewHolder(generalView);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case CostListItem.TYPE_DATE:
                CostDateItem costDateItem = (CostDateItem) itemList.get(position);
                DateViewHolder dateViewHolder = (DateViewHolder) holder;
                dateViewHolder.bind(costDateItem);
                break;
            case CostListItem.TYPE_GENERAL:
                CostGeneralItem costGeneralItem = (CostGeneralItem) itemList.get(position);
                GeneralViewHolder generalViewHolder = (GeneralViewHolder) holder;
                generalViewHolder.bind(costGeneralItem);
                break;
            default:
                throw new IllegalStateException("Unexpected type");
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return itemList.get(position).getType();
    }
}
