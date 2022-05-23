package pl.edu.uwr.pum.recyclerviewselectorjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class NumberListAdapter extends RecyclerView.Adapter<NumberListAdapter.NumberListViewHolder>{

    private final LinkedList<Integer> numberList;

    private SelectionTracker<Long> selectionTracker;
    public void setSelectionTracker(SelectionTracker<Long> selectionTracker) {
        this.selectionTracker = selectionTracker;
    }

    public NumberListAdapter(LinkedList<Integer> numberList){
        this.numberList = numberList;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public NumberListAdapter.NumberListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NumberListViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NumberListAdapter.NumberListViewHolder holder, int position) {
        holder.bind(numberList.get(position), selectionTracker.isSelected((long)position));
    }

    @Override
    public int getItemCount() {
        return numberList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    protected static class NumberListViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public NumberListViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.numberText);
        }

        public ItemDetailsLookup.ItemDetails<Long> getItemDetails() {
            return new ItemDetailsLookup.ItemDetails<Long>() {
                @Override
                public int getPosition() {
                    return getAdapterPosition();
                }

                @NonNull
                @Override
                public Long getSelectionKey() {
                    return getItemId();
                }
            };
        }

        public void bind(int value, boolean isActivated){
            textView.setText(String.valueOf(value));
            itemView.setActivated(isActivated);
        }
    }
}
