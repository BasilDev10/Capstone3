package com.example.capstone3.OutDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@AllArgsConstructor
@Getter
@Setter
public class StoreContractDTO {



    private String storeName;


    private String location;


    private Double area;


    private String description;


    private Double agreedPrice;


    private String contractDetails;


    private LocalDate contractDate;


    private String individualName;


    private String ownerName;

    private LocalDateTime updatedAt;
}
