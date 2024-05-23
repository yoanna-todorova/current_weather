package com.example.current.weather.mappers;

import com.example.current.weather.dtos.GeoLocationDto;
import com.example.current.weather.dtos.WeatherDataDto;
import com.example.current.weather.models.Location;
import com.example.current.weather.models.WeatherData;

import java.sql.Timestamp;

public class WeatherDataMapper {

    public static WeatherData fromWeatherDataDto(WeatherDataDto.Current weatherDto, GeoLocationDto locationDto){
        WeatherData wd = new WeatherData();
        wd.setTemperature(weatherDto.getTemp());
        wd.setWindSpeed(weatherDto.getWindSpeed());
        wd.setCloudiness(weatherDto.getClouds());
        wd.setRealFeel(wd.getRealFeel());
        wd.setHumidity(weatherDto.getHumidity());
        wd.setFetched(new Timestamp(System.currentTimeMillis()));

        Location location = new Location();
        location.setCityName(locationDto.getCityName());
        location.setCountryCode(locationDto.getCountryCode());
        location.setStateCode(locationDto.getStateCode());
        wd.setLocation(location);

        return wd;
    }
}
