package com.saikiran.WeatherNow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WeatherService {

    @Value("${openweather.api.key}")
    private String apiKey;

    public Map getWeather(String city){
        String url= String.format(
                "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric",
                city,
                apiKey
        );
        RestTemplate restTemplate =new RestTemplate();
        Map response=restTemplate.getForObject(url,Map.class);

        return response;
    }
}
