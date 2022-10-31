package pl.udu.uwr.pum.polishnewsapp.shared

import androidx.recyclerview.widget.DiffUtil
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.NewsArticle

class ArticleComparator : DiffUtil.ItemCallback<NewsArticle>() {
    override fun areItemsTheSame(oldItem: NewsArticle, newItem: NewsArticle): Boolean = newItem.url == oldItem.url
    override fun areContentsTheSame(oldItem: NewsArticle, newItem: NewsArticle): Boolean = newItem == oldItem
}