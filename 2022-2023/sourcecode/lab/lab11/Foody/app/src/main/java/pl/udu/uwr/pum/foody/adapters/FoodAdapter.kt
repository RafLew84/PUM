package pl.udu.uwr.pum.foody.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import pl.udu.uwr.pum.foody.data.list.Meal
import pl.udu.uwr.pum.foody.databinding.ListItemRvBinding

class FoodAdapter(itemComparator: FoodComparator) : ListAdapter<Meal, FoodViewHolder>(itemComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(
            ListItemRvBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}