package com.example.controller;

import com.example.entity.Weather;
import com.example.repository.WeatherRepository;
import com.example.service.CacheInspectorService;
import com.example.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;
    @Autowired
    WeatherRepository weatherRepository;
    @Autowired
    CacheInspectorService cacheInspectorService;

    @GetMapping
    public String getWeather(@RequestParam String city) {
        String weather = weatherService.getWeatherByCity(city);
      return weather;
    }


    @PostMapping
    public Weather saveWeather(@RequestBody Weather weather) {
        return weatherRepository.save(weather);
    }

    @GetMapping("/getAll")
    public List<Weather> getAllWeathers() {
        return weatherRepository.findAll();
    }

    @GetMapping("/CacheData")
    public void getWeather() {
        cacheInspectorService.printCacheContent("weather");
    }

    @PutMapping("/update/{city}")
    public String getWeather1(@PathVariable("city") String city, @RequestParam String weather) {
       return weatherService.UpdateWeather(city,weather);
    }
    @DeleteMapping("/{city}")
    public String deleteWeather(@PathVariable("city") String city) {
        weatherService.DeleteWeather(city);
        return "Weather data for" +city +" has been deleted and cache evicted successfully";
    }
}
