package pl.edu.uwr.pum.recyclerviewwordlistkotlin

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordListAdapter(
    private val context: Context,
    private val wordList: MutableList<String>
) : RecyclerView.Adapter<WordListAdapter.WordListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WordListAdapter.WordListViewHolder {
        return WordListViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.word_list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WordListAdapter.WordListViewHolder, position: Int) {
        val word = wordList[position]
        holder.word.text = word
        holder.itemView.setOnClickListener {
            val element = holder.word.text
            holder.word.text = "Clicked $element"
            holder.word.setBackgroundColor(Color.CYAN)
        }
    }

    override fun getItemCount() = wordList.size

    class WordListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val word: TextView = itemView.findViewById((R.id.singleWord))
    }

}