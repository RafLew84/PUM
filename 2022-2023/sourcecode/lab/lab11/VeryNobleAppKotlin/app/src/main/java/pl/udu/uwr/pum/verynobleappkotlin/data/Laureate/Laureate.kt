package pl.udu.uwr.pum.verynobleappkotlin.data.Laureate

import pl.udu.uwr.pum.verynobleappkotlin.data.util.LinkX

data class Laureate(
    val fullName: FullName,
    val id: String,
    val knownName: KnownName,
    val links: List<LinkX>,
    val motivation: Motivation,
    val portion: String,
    val sortOrder: String
)