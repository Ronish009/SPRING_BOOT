package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String forecast;

    public Weather(String city, String forecast) {
        this.city = city;
        this.forecast = forecast;
    }

    public Weather() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", forecast='" + forecast + '\'' +
                '}';
    }
}