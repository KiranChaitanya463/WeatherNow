package com.saikiran.WeatherNow.Service;


import com.saikiran.WeatherNow.Dto.WeatherDto;
import com.saikiran.WeatherNow.Model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WeatherService {

    @Value("${openweather.api.key}")
    private String apiKey;

    public WeatherDto getWeather(String city) {
        String url = String.format(
                "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric",
                city,
                apiKey
        );

        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse response =
                restTemplate.getForObject(url, WeatherResponse.class);

        // extract only fields we want
        String cityName = response.getName();
        String country = response.getSys() != null ? response.getSys().getCountry() : null;
        double temp = response.getMain() != null ? response.getMain().getTemp() : 0.0;
        String description = (response.getWeather() != null && !response.getWeather().isEmpty())
                ? response.getWeather().get(0).getDescription()
                : null;

        return new WeatherDto(cityName, country, temp, description);
    }
}
