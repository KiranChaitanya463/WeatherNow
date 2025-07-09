package com.saikiran.WeatherNow.Controller;

import com.saikiran.WeatherNow.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "http://localhost:3000")
public class WeatherController {

    @Autowired
    private WeatherService service;

    @GetMapping
    public Map getWeather(@RequestParam String city){
        return service.getWeather(city);
    }

}
