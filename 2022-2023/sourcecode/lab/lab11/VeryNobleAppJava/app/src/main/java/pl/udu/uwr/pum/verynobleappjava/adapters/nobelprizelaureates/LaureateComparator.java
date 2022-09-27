package pl.udu.uwr.pum.verynobleappjava.adapters.nobelprizelaureates;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import pl.udu.uwr.pum.verynobleappjava.data.nobelprizeresponse.NobelAwardsResponse;

public class LaureateComparator extends DiffUtil.ItemCallback<NobelAwardsResponse.NobelPrizes.Laureates> {
    @Override
    public boolean areItemsTheSame(@NonNull NobelAwardsResponse.NobelPrizes.Laureates oldItem, @NonNull NobelAwardsResponse.NobelPrizes.Laureates newItem) {
        return oldItem.getId().equals(newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull NobelAwardsResponse.NobelPrizes.Laureates oldItem, @NonNull NobelAwardsResponse.NobelPrizes.Laureates newItem) {
        return newItem.getId().equals(oldItem.getId());
    }
}
