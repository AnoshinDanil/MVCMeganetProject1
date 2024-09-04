package org.example.mvcmeganetproject1.repository;

import org.example.mvcmeganetproject1.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    Optional<City> findCityByName(String name);
}
