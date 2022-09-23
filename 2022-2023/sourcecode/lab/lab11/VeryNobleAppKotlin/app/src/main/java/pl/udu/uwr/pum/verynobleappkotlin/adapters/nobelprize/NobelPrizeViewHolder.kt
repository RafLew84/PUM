package pl.udu.uwr.pum.verynobleappkotlin.adapters.nobelprize

import androidx.recyclerview.widget.RecyclerView
import pl.udu.uwr.pum.verynobleappkotlin.data.nobelprizeresponse.nobelprize.NobelPrize
import pl.udu.uwr.pum.verynobleappkotlin.databinding.NobelPrizeRvItemBinding

class NobelPrizeViewHolder(private val binding: NobelPrizeRvItemBinding)
    : RecyclerView.ViewHolder(binding.root){
        fun bind(item: NobelPrize){
            binding.year.text = item.awardYear
            binding.motivation.text = item.topMotivation.en
            binding.listOfLaureates.text = item.laureates[0].fullName.en
        }
}