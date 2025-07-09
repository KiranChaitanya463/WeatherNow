package com.saikiran.WeatherNow.Dto;

public class WeatherDto {
    private String city;
    private String country;
    private double temperature;
    private String description;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WeatherDto() {
    }

    public WeatherDto(String city, String country, double temperature, String description) {
        this.city = city;
        this.country = country;
        this.temperature = temperature;
        this.description = description;
    }
}
