package pl.udu.uwr.pum.polishnewsapp.data.dto

data class ArticleResponse(
    val nextPage: Int,
    val results: List<Article>,
    val status: String,
    val totalResults: Int
)