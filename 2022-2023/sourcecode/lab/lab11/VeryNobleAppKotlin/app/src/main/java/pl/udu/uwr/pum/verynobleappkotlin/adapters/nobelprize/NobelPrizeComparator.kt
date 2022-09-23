package pl.udu.uwr.pum.verynobleappkotlin.adapters.nobelprize

import androidx.recyclerview.widget.DiffUtil
import pl.udu.uwr.pum.verynobleappkotlin.data.nobelprizeresponse.nobelprize.NobelPrize

class NobelPrizeComparator : DiffUtil.ItemCallback<NobelPrize>() {
    override fun areItemsTheSame(oldItem: NobelPrize, newItem: NobelPrize): Boolean {
        return oldItem.awardYear == newItem.awardYear
    }

    override fun areContentsTheSame(oldItem: NobelPrize, newItem: NobelPrize): Boolean {
        return oldItem == newItem
    }
}