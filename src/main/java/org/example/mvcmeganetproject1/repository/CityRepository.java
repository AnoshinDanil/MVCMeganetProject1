package org.example.mvcmeganetproject1.repository;

import org.example.mvcmeganetproject1.model.City;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

//    @EntityGraph(attributePaths = "streets")
//    Optional<City> findCityByName(String name);

    @Query("SELECT c FROM City c JOIN FETCH c.streets WHERE c.name = :name")
    Optional<City> findCityByNameWithStreets(@Param("name") String name);
}
