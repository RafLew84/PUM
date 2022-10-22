package pl.udu.uwr.pum.offlinecachingbasicsjava.data.response;

import androidx.annotation.NonNull;

public class Address {
    private String city;
    private String street_name;
    private String street_address;
    private String zip_code;
    private String state;
    private String country;

    public Address(String city,
                   String street_name,
                   String street_address,
                   String zip_code,
                   String state,
                   String country) {
        this.city = city;
        this.street_name = street_name;
        this.street_address = street_address;
        this.zip_code = zip_code;
        this.state = state;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
