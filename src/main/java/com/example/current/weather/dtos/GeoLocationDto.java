package com.example.current.weather.dtos;

public class GeoLocationDto {

    private String city_name;
    private String state_code;
    private String country_code;

    public GeoLocationDto(String city_name, String state_code, String country_code) {
        this.city_name = city_name;
        this.state_code = state_code;
        this.country_code = country_code;
    }

    public String getCityName() {
        return city_name;
    }

    public void setCityName(String city_name) {
        this.city_name = city_name;
    }

    public String getStateCode() {
        return state_code;
    }

    public void setStateCode(String state_code) {
        this.state_code = state_code;
    }

    public String getCountryCode() {
        return country_code;
    }

    public void setCountryCode(String country_code) {
        this.country_code = country_code;
    }
}
