package pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.laureate

data class Link(
    val action: String,
    val `class`: List<String>,
    val href: String,
    val rel: String,
    val title: String,
    val types: String
)