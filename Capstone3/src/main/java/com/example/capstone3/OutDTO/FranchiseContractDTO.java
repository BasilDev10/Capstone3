package com.example.capstone3.OutDTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor

// Done by Salem
public class FranchiseContractDTO {


    private String franchiseeName;

    private String franchiseePhone;

    private String franchisorName;

    private String franchisorPhone;

    private String secondPartyName;

    private String secondPartyPhone;

    private String contractDuration;

    private Double investmentAmount;

    private Double ongoingAdminFees;

    private Double agreedFee;

    private String contractDetails;

    private LocalDate contractDate;

    private String status;

    private String message;

}
