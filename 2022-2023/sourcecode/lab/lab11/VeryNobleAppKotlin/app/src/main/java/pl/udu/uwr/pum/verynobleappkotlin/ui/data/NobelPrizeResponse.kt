package pl.udu.uwr.pum.verynobleappkotlin.ui.data

data class NobelPrizeResponse(
    val meta: Meta,
    val nobelPrizes: List<NobelPrize>
)