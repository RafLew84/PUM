package pl.udu.uwr.pum.verynobleappkotlin.adapters.nobleprizelaureate

import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import pl.udu.uwr.pum.verynobleappkotlin.data.nobelprizeresponse.laureate.Laureate
import pl.udu.uwr.pum.verynobleappkotlin.databinding.LaureateRvItemBinding
import pl.udu.uwr.pum.verynobleappkotlin.ui.fragments.nobelaward.NobelAwardFragmentDirections

class LaureateViewHolder(private val binding: LaureateRvItemBinding)
    : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Laureate){
            binding.fullNameTextView.text = item.fullName?.en?: "missing name"
            binding.portionTextView.text = item.portion
            binding.motivationTextView.text = item.motivation.en
            binding.root.setOnClickListener {
                val action: NavDirections = NobelAwardFragmentDirections
                    .actionNobelAwardFragmentToLaureateFragment(item.id)
                Navigation.findNavController(binding.root).navigate(action)
            }
        }
}