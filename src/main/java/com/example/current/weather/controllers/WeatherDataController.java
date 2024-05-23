package com.example.current.weather.controllers;

import com.example.current.weather.constants.Constants;
import com.example.current.weather.constants.CountryCodes;
import com.example.current.weather.dtos.CoordinatedLocationDto;
import com.example.current.weather.dtos.GeoLocationDto;
import com.example.current.weather.dtos.WeatherDataDto;
import com.example.current.weather.mappers.WeatherDataMapper;
import com.example.current.weather.models.WeatherData;
import com.example.current.weather.services.contracts.WeatherDataService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/weather/")
public class WeatherDataController {

    private final WeatherDataService weatherDataService;
    private final WebClient webClient;


    @Autowired
    WeatherDataController(WeatherDataService weatherDataService, WebClient webClient) {
        this.weatherDataService = weatherDataService;
        this.webClient = webClient;
    }

    @PostMapping
    public WeatherData saveFetchedWeatherData(@RequestParam(name = "cityName") String cityName,
                                              @RequestParam(name = "stateCode", required = false) String stateCode,
                                              @RequestParam(name = "countryCode") String countryCode) {
        try {
            CountryCodes.valueOf(countryCode.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    Constants.WRONG_COUNTRY_CODE);
        }
        GeoLocationDto geoLocationDto = new GeoLocationDto(cityName, stateCode, countryCode);

        CoordinatedLocationDto coordinates = transformGeoLocationToCoordinates(geoLocationDto);
        String response = webClient.get()
                .uri(Constants.COORDINATES_LOCATION_URL,
                        coordinates.getLat(),
                        coordinates.getLon(),
                        Constants.API_KEY)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        Gson gson = new Gson();
        WeatherDataDto weatherDataDto = gson.fromJson(response, WeatherDataDto.class);
        WeatherData wd = WeatherDataMapper.fromWeatherDataDto(weatherDataDto.getCurrent(), geoLocationDto);

        return weatherDataService.saveIntoDbThenReturn(wd);

    }

    private CoordinatedLocationDto transformGeoLocationToCoordinates(GeoLocationDto geoLocationDto) {
        String response = webClient.get()
                .uri(Constants.GEO_LOCATION_URL,
                        geoLocationDto.getCityName(),
                        geoLocationDto.getStateCode(),
                        geoLocationDto.getCountryCode(),
                        1,
                        Constants.API_KEY)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        Gson gson = new Gson();
        System.out.println(response);
        CoordinatedLocationDto[] result = gson.fromJson(response, CoordinatedLocationDto[].class);
        return result[0];
    }
}
