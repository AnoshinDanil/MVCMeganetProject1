package org.example.mvcmeganetproject1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    String name;


    @Column(name = "phone")
    @NotEmpty
    @Pattern(
            regexp = "^((8|\\+374|\\+994|\\+995|\\+375|\\+7|\\+380|\\+38|\\+996|\\+998|\\+993)[\\- ]?)?\\(?\\d{3,5}\\)?[\\- ]?\\d{1}[\\- ]?\\d{1}[\\- ]?\\d{1}[\\- ]?\\d{1}[\\- ]?\\d{1}(([\\- ]?\\d{1})?[\\- ]?\\d{1})?$",
            message = "введите номер коректно")
    String phone;

    @NotEmpty
    @Column(name = "street_address")
    String streetAddress;

    @Column
    @NotEmpty
    String city;

    @NotEmpty
    @Column(name = "home_number")
    String homeNumber;

    @Column(name = "connectable")
    private boolean connectable;

}
