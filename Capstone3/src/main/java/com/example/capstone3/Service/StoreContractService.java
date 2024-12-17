package com.example.capstone3.Service;

import com.example.capstone3.Repository.StoreContractRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StoreContractService {
    private final StoreContractRepository storeContractRepository;
}
