package pl.udu.uwr.pum.roombasicsjava.view;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import pl.udu.uwr.pum.roombasicsjava.model.Word;

class WordsComparator extends DiffUtil.ItemCallback<Word> {

    @Override
    public boolean areItemsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
        return oldItem == newItem;
    }

    @Override
    public boolean areContentsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
        return oldItem.getWord().equals(newItem.getWord());
    }
}
