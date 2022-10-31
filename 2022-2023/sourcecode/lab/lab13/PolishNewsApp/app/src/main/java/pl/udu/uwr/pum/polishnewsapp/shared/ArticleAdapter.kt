package pl.udu.uwr.pum.polishnewsapp.shared

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.NewsArticle
import pl.udu.uwr.pum.polishnewsapp.databinding.ItemArticleRvBinding

class ArticleAdapter : ListAdapter<NewsArticle, ArticleViewHolder>(ArticleComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder =
        ArticleViewHolder(ItemArticleRvBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) =
        holder.bind(getItem(position))
}