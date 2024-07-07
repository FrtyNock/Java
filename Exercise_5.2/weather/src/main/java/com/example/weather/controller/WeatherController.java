package com.example.weather.controller;

import com.example.weather.model.Weather;
import com.example.weather.repository.WeatherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherRepository repository;


    @GetMapping
    public Iterable<Weather> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{lat}/{lon}")
    public Optional<Weather> getWeather(@PathVariable double lat, @PathVariable double lon) {
        Iterable<Weather> weatherAll = findAll();
        for (Weather weather : weatherAll) {
            if (weather.getLat() == lat && weather.getLon() == lon) {
                return Optional.of(weather);
            }
        }
        return Optional.empty();
    }

    @PostMapping
    public ResponseEntity<Weather> save(@RequestBody Weather weather) {
        return repository.findById(weather.getId()).isPresent()
                ? new ResponseEntity(repository.findById(weather.getId()), HttpStatus.BAD_REQUEST)
                : new ResponseEntity(repository.save(weather), HttpStatus.CREATED);
    }
}