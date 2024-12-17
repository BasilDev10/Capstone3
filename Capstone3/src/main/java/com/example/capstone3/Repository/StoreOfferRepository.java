package com.example.capstone3.Repository;

import com.example.capstone3.Model.StoreOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreOfferRepository  extends JpaRepository <StoreOffer, Integer>{
    StoreOffer findStoreOfferById(Integer storeOfferId);
}
