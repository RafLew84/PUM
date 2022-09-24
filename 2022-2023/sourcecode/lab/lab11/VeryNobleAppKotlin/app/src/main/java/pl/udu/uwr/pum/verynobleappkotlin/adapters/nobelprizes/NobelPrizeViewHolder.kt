package pl.udu.uwr.pum.verynobleappkotlin.adapters.nobelprizes

import androidx.navigation.NavDirections
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import pl.udu.uwr.pum.verynobleappkotlin.data.nobelprizeresponse.nobelprize.NobelPrize
import pl.udu.uwr.pum.verynobleappkotlin.databinding.NobelPrizeRvItemBinding
import pl.udu.uwr.pum.verynobleappkotlin.ui.fragments.nobleawards.NobelAwardsFragmentDirections
import java.lang.StringBuilder

class NobelPrizeViewHolder(private val binding: NobelPrizeRvItemBinding)
    : RecyclerView.ViewHolder(binding.root){
        fun bind(item: NobelPrize){
            binding.year.text = item.awardYear
            binding.motivation.text = item.topMotivation?.en?:"not specified"
            binding.listOfLaureates.text = laureates(item)
            binding.root.setOnClickListener {
                val action: NavDirections = NobelAwardsFragmentDirections
                    .actionNobelAwardsFragmentToNobelAwardFragment(
                        category = item.category.en,
                        awardYear = item.awardYear
                    )
                findNavController(binding.root).navigate(action)
            }
        }

    private fun laureates(item: NobelPrize): String{
        val laureates = StringBuilder()
        item.laureates?.forEach { laureates.append(it.fullName?.en?:"no name").append(" ; ") }
            ?: laureates.append("no names")
        return laureates.toString()
    }
}