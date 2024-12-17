package com.example.capstone3.Service;

import com.example.capstone3.ApiResponse.ApiException;
import com.example.capstone3.InDTO.StoreCounterOfferDTOIn;
import com.example.capstone3.Model.*;
import com.example.capstone3.OutDTO.StoreCounterOfferDTO;
import com.example.capstone3.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreOfferService {
    private final StoreOfferRepository storeOfferRepository;
    private final StoreRepository storeRepository;
    private final IndividualRepository individualRepository;
    private final OwnerRepository ownerRepository;
    private final MessageRepository messageRepository;

    public List<StoreCounterOfferDTO> getStoreOfferByStoreId(Integer storeId){

        List<StoreOffer> storeOffers = storeOfferRepository.findStoreOfferByStoreId(storeId);
        if(storeOffers.isEmpty()) return new ArrayList<>();

        return storeOffers.stream().map(this::convertToStoreCounterOfferDTO).collect(Collectors.toList());
    }


    public List<StoreCounterOfferDTO> getOfferByIndividualIdAndStoreId(Integer individualId , Integer storeId){
        List<StoreOffer> storeOffers = storeOfferRepository.findStoreOfferByIndividualIdAndStoreId(individualId,storeId);
        if(storeOffers.isEmpty()) return new ArrayList<>();
        return storeOffers.stream().map(this::convertToStoreCounterOfferDTO).collect(Collectors.toList());
    }

    // Make offer with same deal
    public void makeOfferSameDeal(Integer individualId , Integer storeId  ){
        StoreOffer storeOffer =new StoreOffer();
        // check there is offer with same user active in store
        if (storeOfferRepository.getStoreOfferActive(individualId, storeId) == null) throw new ApiException("Error: Duplicated there is store offer active by the user");

        Individual individual = individualRepository.findIndividualById(individualId);
        if (individual == null) throw new ApiException("Error: Individual Not Found");
        Store store = storeRepository.findStoreById(storeId);
        if (store == null) throw new ApiException("Error: Store Offer Not Found");

        // creating the offer with same deal
        storeOffer.setIndividual(individual);
        storeOffer.setStore(store);
        storeOffer.setOfferPrice(store.getOriginalPrice());
        storeOffer.setSameDeal(true);
        storeOffer.setStatus("Pending by owner");
        storeOfferRepository.save(storeOffer);
    }

    // make offer with counter the original deal
    public void makeOfferWithCounter(Integer individualId , Integer storeId , StoreCounterOfferDTOIn storeCounterOfferDTOIn ){
        StoreOffer storeOffer =new StoreOffer();
        // check there is offer with same user active in store
        if (storeOfferRepository.getStoreOfferActive(individualId, storeId) == null) throw new ApiException("Error: Duplicated there is store offer active by the user");

        Individual individual = individualRepository.findIndividualById(individualId);
        if (individual == null) throw new ApiException("Error: Individual Not Found");
        Store store = storeRepository.findStoreById(storeId);
        if (store == null) throw new ApiException("Error: Store Offer Not Found");


        // creating the offer with counter
        storeOffer.setIndividual(individual);
        storeOffer.setStore(store);
        storeOffer.setOfferPrice(storeCounterOfferDTOIn.getCounterPrice());
        storeOffer.setSameDeal(false);
        storeOffer.setStatus("Pending by owner");
        storeOffer = storeOfferRepository.save(storeOffer);

        // Create Message with note from the individual to owner for Negotiation
        Message message  = new Message();
        message.setStoreOffer(storeOffer);
        message.setIndividual(individual);
        message.setMessage(storeCounterOfferDTOIn.getMessage());
        messageRepository.save(message);
    }


    // Owner counter back the deal to individual
    public void ownerCounterOffer( Integer offerId ,Integer ownerId, StoreCounterOfferDTOIn storeCounterOfferDTOIn ){
        StoreOffer storeOffer = storeOfferRepository.findStoreOfferById(offerId);
        if (storeOffer == null) throw new ApiException("Error: Store Offer Not Found");
        // Avoiding the owner make counter when the offer is with same deal
        if (storeOffer.getSameDeal()) throw new ApiException("Error: Store is with same deal you can't make counter offer.");
        Owner owner = ownerRepository.findOwnerById(ownerId);
        if (owner == null) throw new ApiException("Error: Owner Not Found");

        // Avoiding owner updating offer not belong to him
        if (!Objects.equals(storeOffer.getStore().getOwner().getId(), ownerId)) throw new ApiException("Error: this store not belong to the owner");

        // avoiding updating offer when is it closed
        if (storeOffer.getStatus().equalsIgnoreCase("Approved") || storeOffer.getStatus().equalsIgnoreCase("Rejected")) throw new ApiException("Error: this store offer is closed. the store offer status ether is approved or rejected ");

        // avoiding update when offer Pending by individual response
        if (storeOffer.getStatus().equalsIgnoreCase("Pending by individual")) throw new ApiException("Error: this store offer is Pending by the individual you make counter offer.");


        // avoiding owner make counter price greater than original Price
        Double originalPrice = storeOffer.getStore().getOriginalPrice();
        if (storeCounterOfferDTOIn.getCounterPrice() > originalPrice) throw new ApiException("Error: You can't make counter price greater than original Price.");

        storeOffer.setOfferPrice(storeCounterOfferDTOIn.getCounterPrice());
        storeOffer.setStatus("Pending by individual");
        storeOffer.setUpdatedAt(LocalDateTime.now());
        storeOfferRepository.save(storeOffer);

        // Create Message with note from the individual to owner for Negotiation
        Message message  = new Message();
        message.setStoreOffer(storeOffer);
        message.setOwner(owner);
        message.setMessage(storeCounterOfferDTOIn.getMessage());
        messageRepository.save(message);
    }

    // Owner approve or reject the offer 
    public void ownerApproveOrRejected( Integer offerId ,Integer ownerId){

    }

    // individual counter back the deal to owner
    public void individualCounterOffer( Integer offerId,Integer individualId , StoreCounterOfferDTOIn storeCounterOfferDTOIn){
        StoreOffer storeOffer = storeOfferRepository.findStoreOfferById(offerId);
        if (storeOffer == null) throw new ApiException("Error: Store Offer Not Found");
        Individual individual = individualRepository.findIndividualById(individualId);
        if (individual == null) throw new ApiException("Error: Individual Not Found");

        // avoiding individual updating on store offer not belong to him
        if (!Objects.equals(storeOffer.getIndividual().getId(), individual.getId())) throw new ApiException("Error: this store offer not belong to the individual");

        // avoiding updating offer when is it closed
        if (storeOffer.getStatus().equalsIgnoreCase("Approved") || storeOffer.getStatus().equalsIgnoreCase("Rejected")) throw new ApiException("Error: this store offer is closed. the store offer status ether is approved or rejected ");

        // avoiding update when offer Pending by owner response
        if (storeOffer.getStatus().equalsIgnoreCase("Pending by owner")) throw new ApiException("Error: this store offer is Pending by the owner you make counter offer.");

        // avoiding individual make counter price greater than original Price
        Double originalPrice = storeOffer.getStore().getOriginalPrice();
        if (storeCounterOfferDTOIn.getCounterPrice() > originalPrice) throw new ApiException("Error: You can't make counter price greater than original Price.");


        storeOffer.setOfferPrice(storeCounterOfferDTOIn.getCounterPrice());
        storeOffer.setStatus("Pending by owner");
        storeOffer.setUpdatedAt(LocalDateTime.now());
        storeOfferRepository.save(storeOffer);

        // Create Message with note from the individual to owner for Negotiation
        Message message  = new Message();
        message.setStoreOffer(storeOffer);
        message.setIndividual(individual);
        message.setMessage(storeCounterOfferDTOIn.getMessage());
        messageRepository.save(message);
    }

    // individual approve or reject the offer
    public void individualApproveReject(Integer offerId,Integer individualId  , String status){
        StoreOffer storeOffer = storeOfferRepository.findStoreOfferById(offerId);
        if (storeOffer == null) throw new ApiException("Error: Store Offer Not Found");
        Individual individual = individualRepository.findIndividualById(individualId);
        if (individual == null) throw new ApiException("Error: Individual Not Found");

        // avoiding individual updating on store offer not belong to him
        if (!Objects.equals(storeOffer.getIndividual().getId(), individual.getId())) throw new ApiException("Error: this store offer not belong to the individual");

        // avoiding updating offer when is it closed
        if (storeOffer.getStatus().equalsIgnoreCase("Approved") || storeOffer.getStatus().equalsIgnoreCase("Rejected")) throw new ApiException("Error: this store offer is closed. the store offer status ether is approved or rejected ");


        // individual can Reject the offer even is Pending by owner
        if (status.equalsIgnoreCase("Rejected")){
            storeOffer.setStatus("Rejected");
            storeOffer.setUpdatedAt(LocalDateTime.now());
            storeOfferRepository.save(storeOffer);
            return;
        }

        // avoiding update when offer Pending by owner response
        if (storeOffer.getStatus().equalsIgnoreCase("Pending by owner")) throw new ApiException("Error: this store offer is Pending by the owner you can't approve the offer.");

        // if approved set status Pending by owner to approve and convert offer to contract
        if (status.equalsIgnoreCase("Approved")){
            storeOffer.setStatus("Pending by owner");
            storeOffer.setUpdatedAt(LocalDateTime.now());
            storeOfferRepository.save(storeOffer);
        }else throw new ApiException("Error: please enter only ether Approved or Rejected");
    }
    public StoreCounterOfferDTO convertToStoreCounterOfferDTO(StoreOffer storeOffer){
        Store store = storeOffer.getStore();
        Individual individual = storeOffer.getIndividual();

        return new StoreCounterOfferDTO(store.getStoreName(),store.getLocation(),store.getArea(),store.getOriginalPrice(),store.getDescription(),storeOffer.getOfferPrice(),storeOffer.getStatus() , individual.getFullName());
    }
}
