package pl.udu.uwr.pum.foody.adapters

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pl.udu.uwr.pum.foody.data.list.Meal
import pl.udu.uwr.pum.foody.databinding.ListItemRvBinding

class FoodViewHolder(private val binding: ListItemRvBinding)
    : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Meal){
            binding.name.text = item.strMeal
            Glide.with(binding.root)
                .load(item.strMealThumb)
                .into(binding.image)
        }
}