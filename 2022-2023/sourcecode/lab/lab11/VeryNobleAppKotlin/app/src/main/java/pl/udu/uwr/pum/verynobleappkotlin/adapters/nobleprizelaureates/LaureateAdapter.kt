package pl.udu.uwr.pum.verynobleappkotlin.adapters.nobleprizelaureates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import pl.udu.uwr.pum.verynobleappkotlin.data.nobelprizeresponse.laureate.Laureate
import pl.udu.uwr.pum.verynobleappkotlin.databinding.LaureateRvItemBinding

class LaureateAdapter(itemComparator: LaureateComparator) : ListAdapter<Laureate, LaureateViewHolder>(itemComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaureateViewHolder {
        return LaureateViewHolder(
            LaureateRvItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: LaureateViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}