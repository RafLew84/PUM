package pl.udu.uwr.pum.verynobleappkotlin.data

import pl.udu.uwr.pum.verynobleappkotlin.data.meta.Meta
import pl.udu.uwr.pum.verynobleappkotlin.data.nobelprize.NobelPrize

data class NobelPrizeResponse(
    val meta: Meta,
    val nobelPrizes: List<NobelPrize>
)