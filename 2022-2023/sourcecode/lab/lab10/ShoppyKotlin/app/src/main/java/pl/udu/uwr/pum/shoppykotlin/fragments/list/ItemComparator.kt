package pl.udu.uwr.pum.shoppykotlin.fragments.list

import androidx.recyclerview.widget.DiffUtil
import pl.udu.uwr.pum.shoppykotlin.model.Item

class ItemComparator : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.name == newItem.name && oldItem.quantity == newItem.quantity
    }
}