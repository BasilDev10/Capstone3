package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommercialProperties {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // General Shop Information
    @NotEmpty(message = "Shop name is required.")
    private String name;

    @NotEmpty(message = "City is required.")
    private String city;

    @NotEmpty(message = "Location is required.")
    private String location;

    @Positive(message = "Area must be a positive number.")
    private Double area;

    private String facilities;

    // Rental Details
    @NotEmpty(message = "Rental type is required.")
    private String rentalType; // e.g., "Full Rental", "Unit Rental"

    @PositiveOrZero(message = "Monthly rent must be zero or positive.")
    private Double monthlyRent;

    @PositiveOrZero(message = "Security deposit must be zero or positive.")
    private Double securityDeposit;

    @NotEmpty(message = "Lease term is required.")
    private String leaseTerm; // e.g., "1 year", "6 months"

    private Boolean furnished;

    private String furnishingStatus;

    private String equipmentIncluded;

    private Boolean kitchenInstalled;

    // Unit Details (Unit Specific Information)
    @NotEmpty(message = "Unit type is required.")
    private String unitType; // e.g., "Apartment", "Shop", "Office"

    @NotEmpty(message = "Floor number is required.")
    private String floor; // e.g., "Ground", "1st Floor"

    @Positive(message = "Unit age must be a positive number.")
    private Integer unitAge; // Age of the unit in years

    @NotEmpty(message = "Unit number is required.")
    private String unitNumber; // Unit identification number

    @Positive(message = "Unit area must be a positive number.")
    private Double unitArea; // Area of the unit (in square meters)

    @PositiveOrZero(message = "Facade length must be zero or positive.")
    private Double facadeLength; // Length of the facade of the unit

    @NotEmpty(message = "Facade direction is required.")
    private String facadeDirection; // Direction of the facade (e.g., North, South)

    @Positive(message = "Number of parking spaces must be a positive number.")
    private Integer parkingSpaces; // Number of parking spaces for the unit

    @Positive(message = "Signboard area must be a positive number.")
    private Double signboardArea; // Area for the signboard (in square meters)

    @Positive(message = "Number of air conditioning units must be a positive number.")
    private Integer airConditioningUnits; // Number of air conditioning units in the unit

    @NotEmpty(message = "Air conditioning type is required.")
    private String airConditioningType; // Type of air conditioning (e.g., Split, Window)

    @NotEmpty(message = "Unit finishing status is required.")
    private String unitFinishing; // Finishing status (e.g., "Furnished", "Unfurnished")

    // Relations
    @NotNull(message = "Owner is required.")
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    @JsonIgnore
    private Owner owner; // Linked to the Owner entity

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private Set<PropertyOffer> propertyOffers; // Related rental requests

    // Timestamps
    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();


}