package pl.udu.uwr.pum.verynobleappkotlin.adapters.laureatenobleprizes

import androidx.recyclerview.widget.RecyclerView
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.NobelPrize
import pl.udu.uwr.pum.verynobleappkotlin.databinding.LaureateNobelPrizeRvItemBinding

class NobelPrizeViewHolder(private val binding: LaureateNobelPrizeRvItemBinding)
    : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: NobelPrize){
        binding.yearTextView.text = item.awardYear
        binding.portionTextView.text = item.portion
        binding.motivationTextView.text = item.motivation.en
        binding.categoryFullNameTextView.text = item.categoryFullName.en
        binding.affiliationsTextView.text = affiliations(item)
    }

    private fun affiliations(item: NobelPrize): String{
        val affiliations = StringBuilder()
        item.affiliations?.forEach { affiliations.append(it.name.en).append("\n") }
        return affiliations.toString()
    }
}