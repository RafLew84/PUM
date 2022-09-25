package pl.udu.uwr.pum.verynobleappkotlin.adapters.laureatenobleprizes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.NobelPrize
import pl.udu.uwr.pum.verynobleappkotlin.databinding.LaureateNobelPrizeRvItemBinding

class NobelPrizeAdapter(itemComparator: NobelPrizeComparator) : ListAdapter<NobelPrize, NobelPrizeViewHolder>(itemComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NobelPrizeViewHolder {
        return NobelPrizeViewHolder(
            LaureateNobelPrizeRvItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NobelPrizeViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}