package com.example.capstone3.Service;

import com.example.capstone3.Repository.FranchiseOfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class  FranchiseOfferService {

    private final FranchiseOfferRepository franchiseOfferRepository;

}
