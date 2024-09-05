package org.example.mvcmeganetproject1.service;

import org.example.mvcmeganetproject1.model.City;
import org.example.mvcmeganetproject1.model.Street;
import org.example.mvcmeganetproject1.repository.CityRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CityServiceImplTest {
    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityServiceImpl cityService;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Должен находить город по имени")
    void findCityByName() {
        City city = new City();
        city.setName("Москва");

        when(cityRepository.findCityByName("Москва")).thenReturn(Optional.of(city));
        Optional<City> moscowCity = cityService.findCityByName("Москва");

        assertTrue(moscowCity.isPresent());
        assertEquals(city.getName(), moscowCity.get().getName());
        verify(cityRepository,times(1)).findCityByName(city.getName());
    }

    @Test
    @DisplayName("Не должен находить город по несуществующему имени")
    void findCityByName_NotFound() {
        City city = new City();
        city.setName("Вологда");

        when(cityRepository.findCityByName("Вологда")).thenReturn(Optional.empty());
        Optional<City> vologdaCity = cityService.findCityByName(city.getName());

        assertFalse(vologdaCity.isPresent());
    }

    @Test
    @DisplayName("Должен находить улицу в городе если она существует")
    void searchStreetInCity() {
        City city = new City();
        city.setName("Москва");

        Street street = new Street();
        street.setStreetName("street7");

        city.getStreets().add(street);

      assertTrue(cityService.searchStreetInCity(city,"street7"));
      assertFalse(cityService.searchStreetInCity(city,"street71"));

    }


}