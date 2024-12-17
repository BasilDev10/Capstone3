package com.example.capstone3.OutDTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FranchiseDTO {

    private String brandName;

    private String licenseNumber;

    private String contractDuration;

    private Double investmentAmount;

    private Double franchiseFee;

    private Integer numberOfBranches;


    private String countryOfOrigin;

    private String franchiseType;

    private String sector;


    private Double ongoingAdminFees;

    private String description;

    private String supportDetails;

}
