package com.example.current.weather.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "state_code")
    private String stateCode;
    @Column(name = "zip_code")
    private String zipCode;
    @OneToMany(mappedBy = "location")
    private Set<WeatherData> weatherData;
    public Location() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Set<WeatherData> getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(Set<WeatherData> weatherData) {
        this.weatherData = weatherData;
    }
}
