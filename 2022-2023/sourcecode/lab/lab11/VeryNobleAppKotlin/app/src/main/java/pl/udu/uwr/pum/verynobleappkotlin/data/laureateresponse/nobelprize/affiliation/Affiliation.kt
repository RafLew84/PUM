package pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.affiliation

import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.*

data class Affiliation(
    val city: City,
    val cityNow: CityNow,
    val country: Country,
    val countryNow: CountryNow,
    val locationString: LocationString,
    val name: Name,
    val nameNow: NameNow
)