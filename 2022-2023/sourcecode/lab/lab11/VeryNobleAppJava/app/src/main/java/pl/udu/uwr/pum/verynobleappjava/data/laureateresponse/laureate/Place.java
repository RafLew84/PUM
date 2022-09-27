package pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.laureate;

import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize.affiliation.City;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize.affiliation.CityNow;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize.affiliation.Continent;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize.Country;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize.CountryNow;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize.LocationString;

public class Place {
    public City city;
    public Country country;
    public CityNow cityNow;
    public CountryNow countryNow;
    public Continent continent;
    public LocationString locationString;
}
