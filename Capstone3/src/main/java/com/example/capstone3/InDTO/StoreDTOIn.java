package com.example.capstone3.InDTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class StoreDTOIn {




    @NotEmpty(message = "Error:Store Name is required")
    @Size(min = 3, max = 100 ,message = "Error: Store name length must between 3 to 100")
    private String storeName;

    @NotEmpty(message = "Error:location  is required")
    @Size(min = 3, max = 100 ,message = "Error: Store location length must between 3 to 100")
    private String location;

    @NotNull(message = "Error:Area is required")
    @Min(value = 20 , message = "Error:Area must be greater than 20")
    private Double area;

    @NotNull(message = "Error:Price is required")
    @Positive(message = "Error:Price must be greater than 0")

    private Double originalPrice;

    @NotEmpty(message = "Error:description is required")
    @Size(min = 3, max = 250 ,message = "Error: description length must between 3 to 300")
    private String description;

    @NotNull(message = "Error:owner_id is required")
    private Integer owner_id;
}
