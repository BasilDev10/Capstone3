package com.example.capstone3.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface  FranchiseOfferRepository {

    FranchiseOffer findFranchiseOfferById(Integer id);
}
