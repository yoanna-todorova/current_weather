package com.example.current.weather.services.contracts;

import com.example.current.weather.models.WeatherData;

public interface WeatherDataService {
    WeatherData saveIntoDbThenReturn(WeatherData wd);
}
