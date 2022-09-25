package pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.laureate

import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.CountryNow
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.LocationString
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.affiliation.City
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.affiliation.CityNow
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.affiliation.Continent
import pl.udu.uwr.pum.verynobleappkotlin.data.laureateresponse.nobelprize.affiliation.CountryX

data class PlaceX(
    val city: City,
    val cityNow: CityNow,
    val continent: Continent,
    val country: CountryX,
    val countryNow: CountryNow,
    val locationString: LocationString
)