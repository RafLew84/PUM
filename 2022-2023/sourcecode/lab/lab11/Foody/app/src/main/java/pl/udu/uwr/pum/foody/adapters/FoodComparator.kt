package pl.udu.uwr.pum.foody.adapters

import androidx.recyclerview.widget.DiffUtil
import pl.udu.uwr.pum.foody.data.Meal

class FoodComparator : DiffUtil.ItemCallback<Meal>() {
    override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return newItem.strMeal == oldItem.strMeal
    }

    override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return newItem.idMeal == oldItem.idMeal
    }
}