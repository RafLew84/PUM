package pl.udu.uwr.pum.roombasicskotlin.view

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import pl.udu.uwr.pum.roombasicskotlin.model.Word

class WordListAdapter(wordsComparator: WordsComparator) : ListAdapter<Word, WordViewHolder>(wordsComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.word)
    }
}