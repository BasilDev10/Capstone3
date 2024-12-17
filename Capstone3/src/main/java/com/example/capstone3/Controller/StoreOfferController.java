package com.example.capstone3.Controller;

import com.example.capstone3.ApiResponse.ApiResponse;
import com.example.capstone3.InDTO.StoreCounterOfferDTOIn;
import com.example.capstone3.OutDTO.StoreCounterOfferDTO;
import com.example.capstone3.Service.StoreOfferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/deal-hub/store-offer")
public class StoreOfferController {

    private final StoreOfferService storeOfferService;

    @GetMapping("/get/{storeId}")
    public ResponseEntity<List<StoreCounterOfferDTO>> getStoreOffersByStoreId(@PathVariable Integer storeId) {
        return ResponseEntity.ok(storeOfferService.getStoreOfferByStoreId(storeId));
    }

    @GetMapping("/get/{storeId}/individual/{individualId}")
    public ResponseEntity<List<StoreCounterOfferDTO>> getOffersByIndividualIdAndStoreId(@PathVariable Integer storeId, @PathVariable Integer individualId) {
        return ResponseEntity.ok(storeOfferService.getOfferByIndividualIdAndStoreId(individualId, storeId));
    }

    @PostMapping("/add/same-deal/{storeId}/individual/{individualId}")
    public ResponseEntity<ApiResponse> makeOfferSameDeal(@PathVariable Integer storeId, @PathVariable Integer individualId) {
        storeOfferService.makeOfferSameDeal(individualId, storeId);
        return ResponseEntity.ok(new ApiResponse("Offer with the same deal created successfully"));
    }

    @PostMapping("/add/counter-deal/{storeId}/individual/{individualId}")
    public ResponseEntity<ApiResponse> makeOfferWithCounter(@PathVariable Integer storeId, @PathVariable Integer individualId, @RequestBody @Valid StoreCounterOfferDTOIn storeCounterOfferDTOIn) {
        storeOfferService.makeOfferWithCounter(individualId, storeId, storeCounterOfferDTOIn);
        return ResponseEntity.ok(new ApiResponse("Counter offer created successfully"));
    }

    @PostMapping("/counter/{offerId}/individual/{individualId}")
    public ResponseEntity<ApiResponse> individualCounterOffer(@PathVariable Integer offerId, @PathVariable Integer individualId, @RequestBody @Valid StoreCounterOfferDTOIn storeCounterOfferDTOIn) {
        storeOfferService.individualCounterOffer(offerId, individualId, storeCounterOfferDTOIn);
        return ResponseEntity.ok(new ApiResponse("Counter offer updated successfully"));
    }

    @PostMapping("/status/{offerId}/individual/{individualId}")
    public ResponseEntity<ApiResponse> individualApproveOrReject(@PathVariable Integer offerId, @PathVariable Integer individualId, @RequestParam String status) {
        storeOfferService.individualApproveReject(offerId, individualId, status);
        return ResponseEntity.ok(new ApiResponse("Offer status updated successfully"));
    }

    @PostMapping("/counter/{offerId}/owner/{ownerId}")
    public ResponseEntity<ApiResponse> ownerCounterOffer(@PathVariable Integer offerId, @PathVariable Integer ownerId, @RequestBody @Valid StoreCounterOfferDTOIn storeCounterOfferDTOIn) {
        storeOfferService.ownerCounterOffer(offerId, ownerId, storeCounterOfferDTOIn);
        return ResponseEntity.ok(new ApiResponse("Owner counter offer updated successfully"));
    }

    @PostMapping("/status/{offerId}/owner/{ownerId}")
    public ResponseEntity<ApiResponse> ownerApproveOrReject(@PathVariable Integer offerId, @PathVariable Integer ownerId) {
        storeOfferService.ownerApproveOrRejected(offerId, ownerId);
        return ResponseEntity.ok(new ApiResponse("Offer status updated successfully"));
    }
}
