package pl.udu.uwr.pum.polishnewsapp.shared

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import pl.udu.uwr.pum.polishnewsapp.data.db.entities.NewsArticle
import pl.udu.uwr.pum.polishnewsapp.databinding.ItemArticleRvBinding

class ArticleAdapter(
    private val onItemClick: (NewsArticle) -> Unit,
    private val onFavoriteClick: (NewsArticle) -> Unit
) : ListAdapter<NewsArticle, ArticleViewHolder>(ArticleComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder =
        ArticleViewHolder(
            ItemArticleRvBinding.inflate(
                LayoutInflater.from(parent.context), parent, false),
            onItemClick = { handleClick(it, onItemClick) },
            onFavoriteClick = { handleClick(it, onFavoriteClick) }
        )

    private fun handleClick(pos: Int, click: (NewsArticle) -> Unit) {
        val item = getItem(pos)
        if (item != null) click(item)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) =
        holder.bind(getItem(position))
}