package pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize.affiliation;

import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize.Country;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize.CountryNow;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize.LocationString;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize.Name;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize.NameNow;

public class Affiliation {
    public Name name;
    public NameNow nameNow;
    public City city;
    public Country country;
    public CityNow cityNow;
    public CountryNow countryNow;
    public LocationString locationString;
}
