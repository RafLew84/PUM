package pl.udu.uwr.pum.roombasicskotlin.view

import androidx.recyclerview.widget.DiffUtil
import pl.udu.uwr.pum.roombasicskotlin.model.Word

class WordsComparator : DiffUtil.ItemCallback<Word>() {
    override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem.word == newItem.word
    }
}