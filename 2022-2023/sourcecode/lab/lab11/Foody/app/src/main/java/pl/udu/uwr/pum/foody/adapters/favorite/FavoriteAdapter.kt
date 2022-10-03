package pl.udu.uwr.pum.foody.adapters.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import pl.udu.uwr.pum.foody.adapters.FoodComparator
import pl.udu.uwr.pum.foody.data.Meal
import pl.udu.uwr.pum.foody.databinding.ListItemRvBinding

class FavoriteAdapter(itemComparator: FoodComparator) : ListAdapter<Meal, FavoriteViewHolder>(itemComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(
            ListItemRvBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    fun getItemAt(position: Int): Meal{
        return getItem(position)
    }
}