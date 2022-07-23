package pl.edu.uwr.pum.pumapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.edu.uwr.pum.pumapp.R

class ContentAdapter (private val content: List<String>) : RecyclerView.Adapter<ContentAdapter.ViewHolder>() {

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val contentTextView: TextView = view.findViewById(R.id.contentTextView)

        fun bind(text: String){
            contentTextView.text = "- $text"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.content_item_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = content[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = content.size
}


