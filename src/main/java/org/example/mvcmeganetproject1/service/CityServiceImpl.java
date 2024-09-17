package org.example.mvcmeganetproject1.service;

import lombok.RequiredArgsConstructor;
import org.example.mvcmeganetproject1.model.City;
import org.example.mvcmeganetproject1.model.Street;
import org.example.mvcmeganetproject1.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CityServiceImpl implements CityService {

    private static final Logger log = LoggerFactory.getLogger(CityServiceImpl.class);
    private final CityRepository cityRepository;

    @Override
    public Optional<City> findCityByName(String name) {
      return cityRepository.findCityByNameWithStreets(name);
    }

    @Override
    public boolean searchStreetInCity(City city, String streetName) {
        for (Street street : city.getStreets()) {
            if (street.getStreetName().equalsIgnoreCase(streetName)) {
                log.info(streetName + " == " +street.getStreetName() );
                return true;
            }
        }
        return false;
    }
}
