package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FranchiseContracts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false, length = 255)
    @NotBlank(message = "Franchisee Name is required")
    @Size(max = 255, message = "Franchisee Name must not exceed 255 characters")
    private String franchiseeName;

    @Column(nullable = false, length = 15)
    @NotBlank(message = "Franchisee Phone is required")
    @Size(max = 15, message = "Franchisee Phone must not exceed 15 characters")
    private String franchiseePhone;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "Franchisor Name is required")
    @Size(max = 255, message = "Franchisor Name must not exceed 255 characters")
    private String franchisorName;

    @Column(nullable = false, length = 15)
    @NotBlank(message = "Franchisor Phone is required")
    @Size(max = 15, message = "Franchisor Phone must not exceed 15 characters")
    private String franchisorPhone;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "Second Party Name is required")
    @Size(max = 255, message = "Second Party Name must not exceed 255 characters")
    private String secondPartyName;

    @Column(nullable = false, length = 15)
    @NotBlank(message = "Second Party Phone is required")
    @Size(max = 15, message = "Second Party Phone must not exceed 15 characters")
    private String secondPartyPhone;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "Contract Duration is required")
    @Size(max = 50, message = "Contract Duration must not exceed 50 characters")
    private String contractDuration;

    @Column(nullable = false, precision = 12, scale = 2)
    @NotNull(message = "Investment Amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Investment Amount must be greater than 0")
    private Double investmentAmount;

    @Column(precision = 12, scale = 2)
    @DecimalMin(value = "0.0", inclusive = false, message = "Ongoing Admin Fees must be greater than 0")
    private Double ongoingAdminFees;

    @Column(nullable = false, precision = 12, scale = 2)
    @NotNull(message = "Agreed Fee is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Agreed Fee must be greater than 0")
    private Double agreedFee;

    @Column(columnDefinition = "TEXT")
    private String contractDetails;

    @Column(nullable = false)
    @NotNull(message = "Contract Date is required")
    private LocalDate contractDate;


    @Column(nullable = false)
    @NotBlank(message = "Contract Status is required")
    @Pattern(regexp = "^(Express|Active|Terminated )$",
            message = "Contract status must be 'Express', 'Active', 'Terminated' ")
    private String status;


    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message = "Owner is required.")
    @JoinColumn(name = "owner_id", nullable = false)
    @JsonIgnore
    private Owner owner; // المالك كطرف أول

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message = "individual is required.")
    @JoinColumn(name = "individual_id", nullable = false)
    @JsonIgnore
    private Individual individual; // المستخدم كطرف ثاني


    // relations
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "franchise_offer_id", nullable = false)
    private FranchiseOffer franchiseOffer;

}