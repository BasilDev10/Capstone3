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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentalContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    // بيانات العقد
    // General Contract Information
    @NotEmpty(message = "Contract type is required.")
    private String contractType;

    @NotEmpty(message = "Contract number is required.")
    private String contractNumber;

    @NotEmpty(message = "Contract status is required.")
    private String contractStatus;


    @NotEmpty(message = "Place of contract is required.")
    private String contractPlace;

    @NotNull(message = "Start date is required.")
    private LocalDateTime startDate;

    @NotNull(message = "End date is required.")
    private LocalDateTime endDate;

    @NotEmpty(message = "Sealing location is required.")
    private String sealingLocation;

    @NotNull(message = "Sealing date is required.")
    private LocalDateTime sealingDate;

    // Financial Information

    @Positive(message = "Total contract amount must be positive.")
    private Double totalContractAmount;

    @Positive(message = "Rent amount must be positive.")
    private Double rentAmount;

    @PositiveOrZero(message = "Electricity bill must be zero or positive.")
    private Double electricityBill;

    @PositiveOrZero(message = "Water bill must be zero or positive.")
    private Double waterBill;

    @PositiveOrZero(message = "Security deposit must be zero or positive.")
    private Double securityDeposit;

    @PositiveOrZero(message = "Maintenance amount must be zero or positive.")
    private Double maintenanceAmount;

    private Integer billingPeriod;

    private Integer numberOfRecurrings;

    @PositiveOrZero(message = "Amount per bill must be zero or positive.")
    private Double amountPerBill;

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

}
