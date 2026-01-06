package com.example.repository;

import com.example.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<Weather,Long> {

    Optional<Weather> findByCity(String city);

    void deleteByCity(String city);
}
