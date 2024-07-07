package com.example.location.model;

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
public class Location {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String location;
    private double lat;
    private double lon;

    public Location(@NonNull String location, double lat, double lon) {
        this.location = location;
        this.lat = lat;
        this.lon = lon;
    }
}
