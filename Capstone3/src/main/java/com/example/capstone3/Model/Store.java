package com.example.capstone3.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Error:Store Name is required")
    @Size(min = 3, max = 100 ,message = "Error: Store name length must between 3 to 100")
    @Column(nullable = false ,length = 100)
    private String storeName;

    @NotEmpty(message = "Error:location  is required")
    @Size(min = 3, max = 100 ,message = "Error: Store location length must between 3 to 100")
    @Column(nullable = false , length = 100)
    private String location;

    @NotNull(message = "Error:Area is required")
    @Min(value = 20 , message = "Error:Area must be greater than 20")
    @Column(nullable = false)
    private Double area;

    @NotNull(message = "Error:Price is required")
    @Positive(message = "Error:Price must be greater than 0")
    @Column(nullable = false)

    private Double originalPrice;

    @NotEmpty(message = "Error:description is required")
    @Size(min = 3, max = 250 ,message = "Error: description length must between 3 to 300")
    @Column(nullable = false ,length = 250)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;
    @OneToMany(mappedBy = "store" , cascade = CascadeType.ALL)
    private Set<StoreOffer> storeOffers;

    @OneToMany(mappedBy = "store" , cascade = CascadeType.ALL)
    private Set<StoreContract> storeContracts;



}
