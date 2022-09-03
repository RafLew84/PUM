package pl.udu.uwr.pum.roombasicskotlin.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.udu.uwr.pum.roombasicskotlin.R

class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val wordItemView: TextView = itemView.findViewById(R.id.textView)

    fun bind(text: String?) {
        wordItemView.text = text
    }
}