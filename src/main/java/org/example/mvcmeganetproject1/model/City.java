package org.example.mvcmeganetproject1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    private String name;

    @Column
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "city_street",
            joinColumns = @JoinColumn(name = "city_id"),
            inverseJoinColumns = @JoinColumn(name = "street_id")
    )
    private Set<Street> streets = new HashSet<>();

}
