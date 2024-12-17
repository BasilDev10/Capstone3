package com.example.capstone3.OutDTO;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class FranchiseCounterOffer {


    private String FranchiseName;

    private String OfferedBy;

    private Double offeredFee;

    private Double counterOfferFee;

    private String contractDuration;

    private boolean sameDeal= true;

    private String CounterContractDuration;

    private Double investmentAmount;

    private Double CounterInvestmentAmount;


    private Double ongoingAdminFees;

    private Double CounterOngoingAdminFees;

    // ------------------------------
    private String status; // Pending, Negotiation, Accepted, Rejected


}
