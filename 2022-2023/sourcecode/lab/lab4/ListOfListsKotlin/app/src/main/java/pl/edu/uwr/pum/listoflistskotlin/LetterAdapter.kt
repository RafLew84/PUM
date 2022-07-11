package pl.edu.uwr.pum.listoflistskotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class LetterAdapter : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>(){
    private val list = ('A').rangeTo('Z').toList()

    class LetterViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val button: Button = view.findViewById(R.id.button_item)
    }

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        return LetterViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false))
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = list[position]
        holder.button.text = item.toString()
    }
}