package com.example.capstone3.Repository;

import com.example.capstone3.Model.StoreOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreOfferRepository  extends JpaRepository <StoreOffer, Integer>{
    StoreOffer findStoreOfferById(Integer storeOfferId);

    List<StoreOffer> findStoreOfferByStoreId(Integer storeId);

    StoreOffer findStoreOfferByIdAndStoreId(Integer storeOfferId,Integer storeId);
}
