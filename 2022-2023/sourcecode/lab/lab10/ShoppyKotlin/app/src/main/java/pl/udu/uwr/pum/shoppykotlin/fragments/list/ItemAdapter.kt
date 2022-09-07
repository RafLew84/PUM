package pl.udu.uwr.pum.shoppykotlin.fragments.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import pl.udu.uwr.pum.shoppykotlin.model.Item
import pl.udu.uwr.pum.shoppykotlin.databinding.ItemRecyclerviewBinding

class ItemAdapter(itemComparator: ItemComparator) : ListAdapter<Item, ItemViewHolder>(itemComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    public fun getItemAt(position: Int): Item{
        return getItem(position)
    }
}