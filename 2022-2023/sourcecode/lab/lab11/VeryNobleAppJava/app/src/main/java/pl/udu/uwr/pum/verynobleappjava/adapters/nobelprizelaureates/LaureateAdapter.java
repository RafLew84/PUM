package pl.udu.uwr.pum.verynobleappjava.adapters.nobelprizelaureates;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import pl.udu.uwr.pum.verynobleappjava.data.NobelAwardsResponse;
import pl.udu.uwr.pum.verynobleappjava.databinding.LaureateRvItemBinding;

public class LaureateAdapter extends ListAdapter<NobelAwardsResponse.NobelPrizes.Laureates, LaureateViewHolder> {
    public LaureateAdapter(LaureateComparator itemComparator) {
        super(itemComparator);
    }

    @NonNull
    @Override
    public LaureateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LaureateViewHolder(LaureateRvItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull LaureateViewHolder holder, int position) {
        NobelAwardsResponse.NobelPrizes.Laureates item = getItem(position);
        holder.bind(item);
    }
}
