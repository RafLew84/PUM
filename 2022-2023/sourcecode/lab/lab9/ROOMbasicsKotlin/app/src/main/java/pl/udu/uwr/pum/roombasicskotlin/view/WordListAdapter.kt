package pl.udu.uwr.pum.roombasicskotlin.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import pl.udu.uwr.pum.roombasicskotlin.R
import pl.udu.uwr.pum.roombasicskotlin.model.Word

class WordListAdapter(wordsComparator: WordsComparator) : ListAdapter<Word, WordViewHolder>(wordsComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.recyclerview_item, parent, false
        ))
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.word)
    }
}