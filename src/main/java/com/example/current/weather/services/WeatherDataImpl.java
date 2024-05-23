package com.example.current.weather.services;

import com.example.current.weather.models.Location;
import com.example.current.weather.models.WeatherData;
import com.example.current.weather.repositories.LocationRepository;
import com.example.current.weather.repositories.WeatherTrackerRepository;
import com.example.current.weather.services.contracts.WeatherDataService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherDataImpl implements WeatherDataService {

    private final WeatherTrackerRepository weatherTrackerRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public WeatherDataImpl(WeatherTrackerRepository weatherTrackerRepository,
                           LocationRepository locationRepository) {
        this.weatherTrackerRepository = weatherTrackerRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public WeatherData saveIntoDbThenReturn(WeatherData wd) {
        Location location = wd.getLocation();
        locationRepository.save(location);
        WeatherData savedEntity = weatherTrackerRepository.save(wd);
        return weatherTrackerRepository.findById(savedEntity.getId())
                .orElseThrow();
    }
}
