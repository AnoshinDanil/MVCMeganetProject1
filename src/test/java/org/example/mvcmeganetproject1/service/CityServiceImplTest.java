package org.example.mvcmeganetproject1.service;

import org.example.mvcmeganetproject1.model.City;
import org.example.mvcmeganetproject1.model.Street;
import org.example.mvcmeganetproject1.repository.CityRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CityServiceImplTest {
//    @Mock
//    private CityRepository cityRepository;

    //@InjectMocks
    private CityServiceImpl cityService;

    @BeforeEach
    void setUp() {

          }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findCityByName() {
    }

    @Test
    void searchStreetInCity() {
        City city = new City();
        city.setName("Москва");

        Street street = new Street();
        street.setStreetName("street7");

        city.getStreets().add(street);

        //when(cityRepository.findCityByName("Москва")).thenReturn(Optional.of(city));


      assertTrue(cityService.searchStreetInCity(city,"street7"));
      assertFalse(cityService.searchStreetInCity(city,"street71"));



    }
}