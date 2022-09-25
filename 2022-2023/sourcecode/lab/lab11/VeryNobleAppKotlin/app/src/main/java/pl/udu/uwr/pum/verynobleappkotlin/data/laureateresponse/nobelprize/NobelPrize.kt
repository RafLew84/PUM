package pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize

import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.laureate.Link
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.affiliation.Affiliation

data class NobelPrize(
    val affiliations: List<Affiliation>,
    val awardYear: String,
    val category: Category,
    val categoryFullName: CategoryFullName,
    val links: List<Link>,
    val motivation: Motivation,
    val portion: String,
    val prizeAmount: Int,
    val prizeAmountAdjusted: Int,
    val prizeStatus: String,
    val sortOrder: String
)