package pl.udu.uwr.pum.verynobleappkotlin.data

data class NobelPrizeResponse(
    val meta: Meta,
    val nobelPrizes: List<NobelPrize>
)