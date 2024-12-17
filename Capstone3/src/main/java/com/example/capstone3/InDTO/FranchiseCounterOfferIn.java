package com.example.capstone3.InDTO;


import lombok.Data;

@Data
public class FranchiseCounterOfferIn {


    private Integer offerId;


    private Double counterOfferFee;

    private String CounterContractDuration;

    private boolean sameDeal= true;

    private Double CounterInvestmentAmount;

    private Double CounterOngoingAdminFees;




}
