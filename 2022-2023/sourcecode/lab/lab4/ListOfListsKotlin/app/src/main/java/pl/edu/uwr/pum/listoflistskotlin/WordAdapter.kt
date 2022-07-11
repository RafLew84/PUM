package pl.edu.uwr.pum.listoflistskotlin

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(private val letter: String, val context: Context) :
    RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private val words: List<String>

    init {
        words = context.resources.getStringArray(R.array.words).toList()
            .filter { it.startsWith(letter, ignoreCase = true) }
    }

    class WordViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val button: Button = view.findViewById(R.id.button_item)
    }

    override fun getItemCount(): Int = words.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false))
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val item = words[position]
        holder.button.text = item

        holder.button.setOnClickListener {
            val queryUrl: Uri = Uri.parse("https://www.google.com/search?q=${item}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context.startActivity(intent)
        }
    }
}