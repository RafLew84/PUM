package pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.laureate

import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.Country
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.CountryNow
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.LocationString
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.affiliation.City
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.affiliation.CityNow
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.affiliation.Continent

data class Place(
    val city: City,
    val cityNow: CityNow,
    val continent: Continent,
    val country: Country,
    val countryNow: CountryNow,
    val locationString: LocationString
)