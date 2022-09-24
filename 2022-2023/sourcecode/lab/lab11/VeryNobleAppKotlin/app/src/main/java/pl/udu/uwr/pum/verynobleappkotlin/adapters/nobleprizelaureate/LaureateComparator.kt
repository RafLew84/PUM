package pl.udu.uwr.pum.verynobleappkotlin.adapters.nobleprizelaureate

import androidx.recyclerview.widget.DiffUtil
import pl.udu.uwr.pum.verynobleappkotlin.data.nobelprizeresponse.laureate.Laureate

class LaureateComparator : DiffUtil.ItemCallback<Laureate>() {
    override fun areItemsTheSame(oldItem: Laureate, newItem: Laureate): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Laureate, newItem: Laureate): Boolean {
        return oldItem == newItem
    }
}