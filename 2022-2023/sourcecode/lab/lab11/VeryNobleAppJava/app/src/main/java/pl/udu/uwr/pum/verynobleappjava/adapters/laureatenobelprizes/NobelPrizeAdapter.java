package pl.udu.uwr.pum.verynobleappjava.adapters.laureatenobelprizes;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize.NobelPrize;
import pl.udu.uwr.pum.verynobleappjava.databinding.LaureateNobelPrizeRvItemBinding;

public class NobelPrizeAdapter extends ListAdapter<NobelPrize, NobelPrizeViewHolder> {

    public NobelPrizeAdapter(NobelPrizeComparator itemComparator) {
        super(itemComparator);
    }

    @NonNull
    @Override
    public NobelPrizeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NobelPrizeViewHolder(LaureateNobelPrizeRvItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull NobelPrizeViewHolder holder, int position) {
        NobelPrize item = getItem(position);
        holder.bind(item);
    }
}
