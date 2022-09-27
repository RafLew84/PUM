package pl.udu.uwr.pum.verynobleappjava.adapters.laureatenobelprizes;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize.NobelPrize;

public class NobelPrizeComparator extends DiffUtil.ItemCallback<NobelPrize> {
    @Override
    public boolean areItemsTheSame(@NonNull NobelPrize oldItem, @NonNull NobelPrize newItem) {
        return newItem == oldItem;
    }

    @Override
    public boolean areContentsTheSame(@NonNull NobelPrize oldItem, @NonNull NobelPrize newItem) {
        return newItem.awardYear.equals(oldItem.awardYear);
    }
}
