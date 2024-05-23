package com.example.current.weather.repositories;

import com.example.current.weather.models.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}
