package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentalOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    // Rental Request Information
    @NotEmpty(message = "Request type is required.")
    private String requestType; // e.g., "Rent", "Inquiry", etc.

    @NotEmpty(message = "Status is required.")
    private String status; // e.g., "Pending", "Approved", "Rejected"

    @Size(max = 1000, message = "Additional details cannot exceed 1000 characters.")
    private String additionalDetails; // Additional details about the request (optional)

    // Financial Details
    @PositiveOrZero(message = "Proposed rent must be zero or positive.")
    private Double proposedRent; // Rent proposed by the user (optional)

    @PositiveOrZero(message = "Deposit amount must be zero or positive.")
    private Double depositAmount; // Security deposit proposed by the user (optional)

    // Request Dates
    @NotNull(message = "Request date is required.")
    private LocalDateTime requestDate; // Date when the request was made

    private LocalDateTime responseDate; // Date when the request was responded to (optional)

    // Timestamps
    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();



}
