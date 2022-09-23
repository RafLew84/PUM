package pl.udu.uwr.pum.verynobleappkotlin.data.nobelprizeresponse

import pl.udu.uwr.pum.verynobleappkotlin.data.nobelprizeresponse.meta.Meta
import pl.udu.uwr.pum.verynobleappkotlin.data.nobelprizeresponse.nobelprize.NobelPrize

data class NobelPrizeResponse(
    val meta: Meta,
    val nobelPrizes: List<NobelPrize>
)