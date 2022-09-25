package pl.udu.uwr.pum.verynobleappkotlin.adapters.laureatenobleprizes

import androidx.recyclerview.widget.DiffUtil
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.NobelPrize

class NobelPrizeComparator : DiffUtil.ItemCallback<NobelPrize>() {
    override fun areItemsTheSame(oldItem: NobelPrize, newItem: NobelPrize): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: NobelPrize, newItem: NobelPrize): Boolean {
        return oldItem == newItem
    }
}