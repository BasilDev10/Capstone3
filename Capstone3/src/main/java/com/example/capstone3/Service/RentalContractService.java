package com.example.capstone3.Service;

import com.example.capstone3.Repository.RentalContractRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentalContractService {
    private final RentalContractRepository rentalContractRepository;
}
