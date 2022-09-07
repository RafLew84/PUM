package pl.udu.uwr.pum.shoppykotlin.fragments.list

import androidx.recyclerview.widget.RecyclerView
import pl.udu.uwr.pum.shoppykotlin.data.Item
import pl.udu.uwr.pum.shoppykotlin.databinding.ItemRecyclerviewBinding

class ItemViewHolder(private val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item) {
        binding.nameTextViewRV.text = item.name
        binding.quantityTextViewRV.text = item.quantity.toString()
    }
}