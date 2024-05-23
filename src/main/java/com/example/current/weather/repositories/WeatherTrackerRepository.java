package com.example.current.weather.repositories;

import com.example.current.weather.models.WeatherData;
import org.springframework.data.repository.CrudRepository;
public interface WeatherTrackerRepository extends CrudRepository<WeatherData, Long> {
}
