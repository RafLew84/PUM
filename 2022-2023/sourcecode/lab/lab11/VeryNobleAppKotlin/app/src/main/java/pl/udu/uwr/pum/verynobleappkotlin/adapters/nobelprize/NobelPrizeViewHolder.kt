package pl.udu.uwr.pum.verynobleappkotlin.adapters.nobelprize

import androidx.recyclerview.widget.RecyclerView
import pl.udu.uwr.pum.verynobleappkotlin.data.nobelprizeresponse.nobelprize.NobelPrize
import pl.udu.uwr.pum.verynobleappkotlin.databinding.NobelPrizeRvItemBinding
import java.lang.StringBuilder

class NobelPrizeViewHolder(private val binding: NobelPrizeRvItemBinding)
    : RecyclerView.ViewHolder(binding.root){
        fun bind(item: NobelPrize){
            binding.year.text = item.awardYear
            binding.motivation.text = item.topMotivation?.en?:"not specified"
            binding.listOfLaureates.text = laureates(item)
        }

    private fun laureates(item: NobelPrize): String{
        val laureates = StringBuilder()
        item.laureates?.forEach { laureates.append(it.fullName.en).append(" ; ") }
            ?: laureates.append("no names")
        return laureates.toString()
    }
}