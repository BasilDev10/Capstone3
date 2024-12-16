package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Username is required")
    @Size(min = 6, message = "Username must be at least 6 characters long")
    @Column(columnDefinition = "VARCHAR(30) NOT NULL UNIQUE")
    private String username;

    @NotEmpty(message = "Password is required")
    @Size(min = 8,message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d).{6,}$",message = "Password must have characters and digits")
    @Column(columnDefinition = "VARCHAR(18) NOT NULL")
    private String password;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email must be a valid email address")
    @Column(columnDefinition = "VARCHAR(60) NOT NULL UNIQUE")
    private String email;

    @NotEmpty(message = "PhoneNumber is required")
    @Pattern(regexp = "^\\+9665[0-9]{8}$", message = "Phone number must be a valid Saudi number starting with +9665 and followed by 8 digits")
    @Column(columnDefinition = "VARCHAR(60) NOT NULL UNIQUE")
    private String phoneNumber;

    @NotEmpty(message = "National ID or business registration is required.")
    @Column(columnDefinition = "varchar(10) not null")
    private String nationalId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<PropertyOffer> propertyOffers;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<PropertyContract> propertyContracts;

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

}
