package org.example.mvcmeganetproject1.service;

import lombok.RequiredArgsConstructor;
import org.example.mvcmeganetproject1.model.City;
import org.example.mvcmeganetproject1.model.Street;
import org.example.mvcmeganetproject1.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public Optional<City> findCityByName(String name) {
      return cityRepository.findCityByName(name);
    }

    @Override
    public boolean searchStreetInCity(City city,String streetName) {
        for (Street street : city.getStreets()) {
            if (street.getStreetName().equalsIgnoreCase(streetName)){
                return true;
            }
        }
        return false;
    }
}
