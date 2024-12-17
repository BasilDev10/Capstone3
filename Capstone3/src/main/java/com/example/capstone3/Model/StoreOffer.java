package com.example.capstone3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoreOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull(message = "Error:Offered price is required")
    @Positive(message = "Error:Price must be greater than 0")
    @Column(nullable = false)
    private Double counterPrice;



    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(nullable = false)
    @NotBlank(message = "Error:Status is required")
    @Pattern(regexp = "^(Pending|Negotiation|Accepted|Rejected)$",
            message = "contract status must be 'Pending', 'Negotiation', 'Accepted', 'Rejected'")
    private String status; // Pending, Negotiation, Accepted, Rejected


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "individual_id", nullable = false)
    private Individual individual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @OneToMany(mappedBy = "storeOffer")
    private Set<StoreContract> storeContracts;
}
