package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentalOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "Status is required.")
    @Pattern(regexp = "^(Pending|Negotiation|Accepted|Rejected)$",
            message = "contract status must be 'Pending', 'Negotiation', 'Accepted', 'Rejected'")
    @Column(columnDefinition = "varchar(10) default 'Pending'")
    private String status = "Pending"; // Pending, Negotiation, Accepted, Rejected


    @NotEmpty(message = "Rental type is required.")
    @Pattern(regexp = "^(Yearly|Monthly|Quarterly|Semi-Annual)$",
            message = "Contract status must be 'Yearly', 'Monthly', 'Quarterly','Semi-Annual' ")
    private String rentalType;


    // Financial Details
    @PositiveOrZero(message = "Proposed rent must be zero or positive.")
    private Double proposedRent; // Rent proposed by the user


    // Timestamps
    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();


    //  Shop Details

    @ManyToOne
    @NotNull(message = "Shop is required.")
    @JoinColumn(name = "rental_id", nullable = false)
    @JsonIgnore
    private Rental rental;

    //contract

    @OneToMany(mappedBy = "rentalOffer")
    private Set<RentalContract> rentalContracts;

    // User Details
    @ManyToOne(fetch = FetchType.LAZY)

    @NotNull(message = "individual is required.")
    @JoinColumn(name = "individual_id", nullable = false)
    @JsonIgnore
    private Individual individual; // Linked to the User entity



}
