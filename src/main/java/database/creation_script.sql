CREATE TABLE location (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    city_name VARCHAR(255),
    country_code VARCHAR(10),
    state_code VARCHAR(10),
    zip_code VARCHAR(20)
);

CREATE TABLE weather_data (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    timestamp_fetched TIMESTAMP,
    location_id BIGINT,
    temperature DOUBLE,
    real_feel DOUBLE,
    humidity INT,
    cloudiness INT,
    wind_speed DOUBLE,
    FOREIGN KEY (location_id) REFERENCES location(id)
);