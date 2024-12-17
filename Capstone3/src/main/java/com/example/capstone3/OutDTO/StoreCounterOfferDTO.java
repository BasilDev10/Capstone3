package com.example.capstone3.OutDTO;


import com.example.capstone3.Model.Individual;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StoreCounterOfferDTO {

    private String StoreName;

    private String location;


    private Double area;


    private Double originalPrice;


    private String description;

    private Double counterPrice;

    private String status;

    private String individualName;

}
