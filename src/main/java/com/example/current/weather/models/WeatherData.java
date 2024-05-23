package com.example.current.weather.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "weather_data")
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "timestamp_fetched")
    private Timestamp fetched;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @Column(name = "temperature")
    private Double temperature;
    @Column(name = "real_feel")
    private Double realFeel;
    @Column(name = "humidity")
    private Integer humidity;
    @Column(name = "cloudiness")
    private Integer cloudiness;
    @Column(name = "wind_speed")
    private Double windSpeed;

    public WeatherData(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getFetched() {
        return fetched;
    }

    public void setFetched(Timestamp fetched) {
        this.fetched = fetched;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getRealFeel() {
        return realFeel;
    }

    public void setRealFeel(Double realFeel) {
        this.realFeel = realFeel;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }
    public Integer getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(Integer cloudiness) {
        this.cloudiness = cloudiness;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
