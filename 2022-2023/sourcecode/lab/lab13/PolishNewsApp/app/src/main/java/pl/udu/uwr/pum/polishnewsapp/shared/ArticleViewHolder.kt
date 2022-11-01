package pl.udu.uwr.pum.polishnewsapp.shared

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pl.udu.uwr.pum.polishnewsapp.R
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.NewsArticle
import pl.udu.uwr.pum.polishnewsapp.databinding.ItemArticleRvBinding

class ArticleViewHolder(private val binding: ItemArticleRvBinding)
    : RecyclerView.ViewHolder(binding.root){
        fun bind(item: NewsArticle){
            binding.apply {
                titleTextView.text = item.title?:""
                descriptionTextView.text = item.description?:""
                if (item.imageUrl != null)
                    Glide.with(itemView)
                        .load(item.imageUrl)
                        .into(articleImageView)
                else {
                    Glide.with(itemView).clear(articleImageView)
                    articleImageView.setImageResource(R.drawable.no_image)
                }

                favoriteImageView.setImageResource(
                    when{
                        item.isFavorite -> R.drawable.ic_favorite_selected
                        else -> R.drawable.ic_favorite_unselected
                    }
                )
            }
        }
}