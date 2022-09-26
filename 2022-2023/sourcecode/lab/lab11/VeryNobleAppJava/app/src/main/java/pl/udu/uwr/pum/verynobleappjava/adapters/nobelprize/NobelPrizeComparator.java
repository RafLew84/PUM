package pl.udu.uwr.pum.verynobleappjava.adapters.nobelprize;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import pl.udu.uwr.pum.verynobleappjava.data.NobelAwardsResponse;

public class NobelPrizeComparator extends DiffUtil.ItemCallback<NobelAwardsResponse.NobelPrizes> {
    @Override
    public boolean areItemsTheSame(@NonNull NobelAwardsResponse.NobelPrizes oldItem, @NonNull NobelAwardsResponse.NobelPrizes newItem) {
        return newItem == oldItem;
    }

    @Override
    public boolean areContentsTheSame(@NonNull NobelAwardsResponse.NobelPrizes oldItem, @NonNull NobelAwardsResponse.NobelPrizes newItem) {
        return newItem.getAwardYear().equals(oldItem.getAwardYear());
    }
}
