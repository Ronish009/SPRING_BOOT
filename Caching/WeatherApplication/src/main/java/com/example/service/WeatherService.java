package com.example.service;

import com.example.entity.Weather;
import com.example.exception.WeatherException;
import com.example.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class WeatherService {

    @Autowired
    WeatherRepository weatherRepository;
    @Cacheable(value = "weather", key = "#city")
    public String getWeatherByCity(String city){
        System.out.println("Fetching data from DB for City: "+city);
        Optional<Weather> weather = weatherRepository.findByCity(city);
        return weather.map(Weather::getForecast).orElseThrow(()->new WeatherException("No Weather Found"));
    }

    @CachePut(value = "weather", key = "#city")
    public String UpdateWeather(String city, String weat){
        System.out.println("Updating weather data from DB for City: "+city);
        weatherRepository.findByCity(city).ifPresent(weather -> {
            weather.setForecast(weat);
            weatherRepository.save(weather);

        });
        return weat;
    }

    @Transactional
    @CacheEvict(value = "weather", key = "#city")
    public void DeleteWeather(String city){
        System.out.println("Deleting weather data from DB for City: "+city);
        weatherRepository.deleteByCity(city);
    }
}
