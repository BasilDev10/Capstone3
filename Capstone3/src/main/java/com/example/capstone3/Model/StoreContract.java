package com.example.capstone3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StoreContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Error:Price is required")
    @Positive(message = "Error:Price must be greater than 0")
    @Column(nullable = false)
    private Double agreedPrice;

    @NotNull(message = "Error:Contract Details is required")
    @Column(nullable = false)
    private String contractDetails;

    @NotNull(message = "Error:Contract Date is required")
    @PastOrPresent(message = "Error: contractDate must be in present or past")
    @Column(nullable = false)
    private LocalDate contractDate;


    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now() ;
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now() ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_offer_id", nullable = false)
    private StoreOffer storeOffer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "individual_id", nullable = false)
    private Individual individual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;
}
