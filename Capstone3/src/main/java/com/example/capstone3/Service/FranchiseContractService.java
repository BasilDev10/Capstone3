package com.example.capstone3.Service;

import com.example.capstone3.Repository.FranchiseContractRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class  FranchiseContractService {

    private final FranchiseContractRepository franchiseContractRepository;
}
