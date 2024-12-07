package com.jeffhb60.bugfreejourney.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity @Table(name = "addresses")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Address {

    @Column(name = "address_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(name = "street")
    @NotBlank @Size(min = 5, message = "Street name must be at least 5 characters")
    private String street;

    @Column(name = "building_name")
    private String buildingName;

    @Column(name = "city")
    @NotBlank @Size(min = 4, message = "City name must be at least 4 characters")
    private String city;

    @Column(name = "state")
    @NotBlank @Size(min = 2, message = "State name must be at least 2 characters")
    private String state;

    @Column(name = "country")
    @NotBlank @Size(min = 2, message = "Country name must be at least 2 characters")
    private String country;

    @Column(name = "postal_code")
    @NotBlank @Size(min = 5, message = "Postal code must be at least 5 characters")
    private String postalCode;


    @ManyToOne @JoinColumn(name = "user_id") @ToString.Exclude
    private User user;

    public Address(String street, String buildingName, String city, String state, String postalCode, User user) {
        this.street = street;
        this.buildingName = buildingName;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = "United States of America";
        this.user = user;
    }


}

