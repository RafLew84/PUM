package pl.udu.uwr.pum.verynobleappjava.adapters.nobelprize;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import pl.udu.uwr.pum.verynobleappjava.data.NobelAwardsResponse;
import pl.udu.uwr.pum.verynobleappjava.databinding.NobelPrizeRvItemBinding;

public class NobelPrizeAdapter extends ListAdapter<NobelAwardsResponse.NobelPrizes, NobelPrizeViewHolder> {
    public NobelPrizeAdapter(NobelPrizeComparator itemComparator) {
        super(itemComparator);
    }

    @NonNull
    @Override
    public NobelPrizeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NobelPrizeViewHolder(NobelPrizeRvItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull NobelPrizeViewHolder holder, int position) {
        NobelAwardsResponse.NobelPrizes item = getItem(position);
        holder.bind(item);
    }
}
