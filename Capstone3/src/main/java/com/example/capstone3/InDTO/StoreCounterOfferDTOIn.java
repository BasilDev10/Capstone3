package com.example.capstone3.InDTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StoreCounterOfferDTOIn {



    @NotNull(message = "Error:Offered price is required")
    @Positive(message = "Error:Price must be greater than 0")
    private Double counterPrice;

    private String message;

}
