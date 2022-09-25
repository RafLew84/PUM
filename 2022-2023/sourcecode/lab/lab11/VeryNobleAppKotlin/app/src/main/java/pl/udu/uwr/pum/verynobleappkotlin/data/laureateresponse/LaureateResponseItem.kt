package pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse

import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.laureate.*
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.meta.Meta
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.NobelPrize
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.wiki.Wikidata
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.wiki.Wikipedia

data class LaureateResponseItem(
    val birth: Birth,
    val death: Death?,
    val familyName: FamilyName,
    val fileName: String,
    val fullName: FullName,
    val gender: String,
    val givenName: GivenName,
    val id: String,
    val knownName: KnownName,
    val links: List<Link>,
    val meta: Meta,
    val nobelPrizes: List<NobelPrize>,
    val sameAs: List<String>,
    val wikidata: Wikidata,
    val wikipedia: Wikipedia
)