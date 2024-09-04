package org.example.mvcmeganetproject1.service;

import org.example.mvcmeganetproject1.model.City;

import java.util.Optional;

public interface CityService {
    Optional<City> findCityByName(String name);

    boolean searchStreetInCity(City city,String streetName);
}
