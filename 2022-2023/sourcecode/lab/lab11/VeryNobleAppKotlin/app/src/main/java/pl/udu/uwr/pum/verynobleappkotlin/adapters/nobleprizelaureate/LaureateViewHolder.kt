package pl.udu.uwr.pum.verynobleappkotlin.adapters.nobleprizelaureate

import androidx.recyclerview.widget.RecyclerView
import pl.udu.uwr.pum.verynobleappkotlin.data.nobelprizeresponse.laureate.Laureate
import pl.udu.uwr.pum.verynobleappkotlin.databinding.LaureateRvItemBinding

class LaureateViewHolder(private val binding: LaureateRvItemBinding)
    : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Laureate){
            binding.fullNameTextView.text = item.fullName?.en?: "missing name"
            binding.portionTextView.text = item.portion
            binding.motivationTextView.text = item.motivation.en
        }
}