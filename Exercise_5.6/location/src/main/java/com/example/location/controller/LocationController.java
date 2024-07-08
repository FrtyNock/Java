package com.example.location.controller;

import com.example.location.model.Geodata;
import com.example.location.model.Weather;
import com.example.location.repository.GeodataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@RestController
public class LocationController {

    @Autowired
    private GeodataRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    // Получить все List<Location>
    @GetMapping("/locations")
    public Iterable<Geodata> getLocations() {
        return repository.findAll();
    }

    // Получить Location по name
    @GetMapping("location")
    public Optional<Geodata> getLocationByName(@RequestParam String name) {
        Optional<Geodata> optionalGeodata = repository.findByName(name);
        if (optionalGeodata.isPresent()) {
            Geodata geodata = optionalGeodata.get();
            return Optional.of(geodata);
        } else {
            return Optional.empty();
        }

    }

    // Добавить новый Location
    @PostMapping("/location")
    public Geodata save(@RequestBody Geodata geodata) {
        return repository.save(geodata);
    }

    // Изменить Location по name
    @PutMapping("/location")
    public ResponseEntity<Geodata> update(@RequestParam String name, @RequestBody Geodata geodataNew) {
        Optional<Geodata> optionalGeodata = repository.findByName(name);
        if (optionalGeodata.isPresent()) {
            Geodata geodata = optionalGeodata.get();
            geodataNew.setId(geodata.getId());
            return new ResponseEntity<>(repository.save(geodataNew), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(save(geodataNew), HttpStatus.CREATED);
        }
    }

    // Удалить Location по name
    @DeleteMapping("location")
    public void delete(@RequestParam String name) {
        Geodata geodata = repository.findByName(name).get();
        repository.delete(geodata);
    }

    // Получить погоду для Location по name
    @GetMapping("location/weather")
    public Weather redirectRequestWeather(@RequestParam String name) {
        Optional<Geodata> optionalGeodata = repository.findByName(name);
        if (optionalGeodata.isPresent()) {
            Geodata geodata = optionalGeodata.get();
            String url = String.format("http://localhost:8082/weather?lat=%s&lon=%s", geodata.getLat(), geodata.getLon());
            return restTemplate.getForObject(url, Weather.class);
        } else {
            throw new RuntimeException("Geodata not found for name: " + name);
        }
    }
}
