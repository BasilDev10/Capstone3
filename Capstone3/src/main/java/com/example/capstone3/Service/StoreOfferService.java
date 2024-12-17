package com.example.capstone3.Service;

import com.example.capstone3.ApiResponse.ApiException;
import com.example.capstone3.Model.Individual;
import com.example.capstone3.Model.Store;
import com.example.capstone3.Model.StoreOffer;
import com.example.capstone3.OutDTO.StoreCounterOfferDTO;
import com.example.capstone3.Repository.StoreOfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreOfferService {
    private final StoreOfferRepository storeOfferRepository;

    public List<StoreCounterOfferDTO> getStoreOfferByStoreId(Integer storeId){
        return storeOfferRepository.findStoreOfferByStoreId(storeId).stream().map(this::convertToStoreCounterOfferDTO).collect(Collectors.toList());
    }

    public StoreCounterOfferDTO getStoreOfferByIdAndStoreId(Integer offerId, Integer storeId ){

        StoreOffer storeOffer = storeOfferRepository.findStoreOfferByIdAndStoreId(offerId, storeId);
        if(storeOffer == null)throw new ApiException("Error: Store Offer Not Found");
        return convertToStoreCounterOfferDTO(storeOffer);
    }

    public void makeOffer(Integer individualId , Integer storeId  ){

    }


    public StoreCounterOfferDTO convertToStoreCounterOfferDTO(StoreOffer storeOffer){
        Store store = storeOffer.getStore();
        Individual individual = storeOffer.getIndividual();

        return new StoreCounterOfferDTO(store.getStoreName(),store.getLocation(),store.getArea(),store.getOriginalPrice(),store.getDescription(),storeOffer.getCounterPrice(),storeOffer.getStatus() , individual.getFullName());
    }
}
