package pl.udu.uwr.pum.verynobleappkotlin.adapters.nobelprize

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import pl.udu.uwr.pum.verynobleappkotlin.data.nobelprizeresponse.nobelprize.NobelPrize
import pl.udu.uwr.pum.verynobleappkotlin.databinding.NobelPrizeRvItemBinding

class NobelPrizeAdapter(itemComparator: NobelPrizeComparator) : ListAdapter<NobelPrize, NobelPrizeViewHolder>(itemComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NobelPrizeViewHolder {
        return NobelPrizeViewHolder(NobelPrizeRvItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: NobelPrizeViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    fun getItemAt(position: Int): NobelPrize{
        return getItem(position)
    }
}