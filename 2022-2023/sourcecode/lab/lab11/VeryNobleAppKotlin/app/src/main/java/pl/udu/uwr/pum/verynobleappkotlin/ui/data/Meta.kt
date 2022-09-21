package pl.udu.uwr.pum.verynobleappkotlin.ui.data

data class Meta(
    val count: Int,
    val disclaimer: String,
    val license: String,
    val limit: Int,
    val nobelPrizeCategory: String,
    val nobelPrizeYear: Int,
    val offset: Int,
    val terms: String,
    val yearTo: Int
)