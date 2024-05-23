package com.example.current.weather.constants;

public class Constants {

    public static String API_KEY = "29da17ff140deffce5b2a136c329d7f7";
    public static String GEO_LOCATION_URL ="http://api.openweathermap.org/geo/1.0/direct?q={city name},{state code},{country code}&limit={limit}&appid={API key}";
    public static String COORDINATES_LOCATION_URL ="https://api.openweathermap.org/data/3.0/onecall?lat={lat}&lon={lon}&appid={API key}";

    public static String WRONG_COUNTRY_CODE = "You are providing wrong country code, please check it again and retry!";
}
