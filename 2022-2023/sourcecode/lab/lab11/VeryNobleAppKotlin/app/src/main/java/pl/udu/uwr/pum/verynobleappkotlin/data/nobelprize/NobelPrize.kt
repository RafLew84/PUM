package pl.udu.uwr.pum.verynobleappkotlin.data.nobelprize

import pl.udu.uwr.pum.verynobleappkotlin.data.Laureate.Laureate
import pl.udu.uwr.pum.verynobleappkotlin.data.util.LinkX

data class NobelPrize(
    val awardYear: String,
    val category: Category,
    val categoryFullName: CategoryFullName,
    val dateAwarded: String,
    val laureates: List<Laureate>,
    val links: List<LinkX>,
    val prizeAmount: Int,
    val prizeAmountAdjusted: Int,
    val topMotivation: TopMotivation
)