package com.example.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Weather {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private double lat;
    private double lon;

    private double temp; // температура
    private double humidity; // влажность
    private double wind_speed; // скорость ветра

    public Weather(double lat, double lon, double temp, double humidity, double wind_speed) {
        this.lat = lat;
        this.lon = lon;
        this.temp = temp;
        this.humidity = humidity;
        this.wind_speed = wind_speed;
    }





}
