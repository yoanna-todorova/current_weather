package com.example.current.weather.dtos;

public class WeatherDataDto {
        Current current;

    public static class Current{
        double temp;
        double feels_like;
        int humidity;
        int clouds;
        double wind_speed;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getFeelsLike() {
            return feels_like;
        }

        public void setFeelsLike(double feels_like) {
            this.feels_like = feels_like;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public int getClouds() {
            return clouds;
        }

        public void setClouds(int clouds) {
            this.clouds = clouds;
        }

        public double getWindSpeed() {
            return wind_speed;
        }

        public void setWindSpeed(double wind_speed) {
            this.wind_speed = wind_speed;
        }
    }



    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }
}
