package com.example.capstone3.OutDTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StoreCounterOfferDTO {

    private String StoreName;

    private String location;


    private Double area;


    private Double originalPrice;


    private String description;

    private Double counterPrice;

    private String status; // Pending, Negotiation, Accepted, Rejected

}
