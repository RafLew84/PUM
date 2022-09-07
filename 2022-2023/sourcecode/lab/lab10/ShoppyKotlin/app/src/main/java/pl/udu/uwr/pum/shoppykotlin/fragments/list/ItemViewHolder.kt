package pl.udu.uwr.pum.shoppykotlin.fragments.list

import androidx.navigation.NavDirections
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import pl.udu.uwr.pum.shoppykotlin.model.Item
import pl.udu.uwr.pum.shoppykotlin.databinding.ItemRecyclerviewBinding

class ItemViewHolder(private val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item) {
        binding.nameTextViewRV.text = item.name
        binding.quantityTextViewRV.text = item.quantity.toString()

        binding.root.setOnClickListener {
            val action: NavDirections = ListFragmentDirections
                .actionListFragmentToUpdateFragment(item.id)
            findNavController(binding.root).navigate(action)
        }
    }
}