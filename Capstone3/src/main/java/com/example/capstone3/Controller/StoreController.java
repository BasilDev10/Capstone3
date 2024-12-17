package com.example.capstone3.Controller;

import com.example.capstone3.ApiResponse.ApiResponse;
import com.example.capstone3.InDTO.StoreDTOIn;
import com.example.capstone3.OutDTO.StoreDTO;
import com.example.capstone3.Service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/deal-hub/store")
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/get")
    public ResponseEntity<List<StoreDTO>> getAllStore() {
        return ResponseEntity.ok(storeService.getAllStores());
    }

    @GetMapping("/get/{storeId}")
    public ResponseEntity<StoreDTO> getStoreById(@PathVariable Integer storeId) {
        return ResponseEntity.ok(storeService.getStoreById(storeId));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addStore(@RequestBody @Valid StoreDTOIn storeDTOIn) {
        storeService.addStore(storeDTOIn);
        return ResponseEntity.ok(new ApiResponse("Store added successfully"));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateStore(@PathVariable Integer id, @RequestBody @Valid StoreDTOIn storeDTOIn) {
        storeService.updateStore(id,storeDTOIn);
        return ResponseEntity.ok(new ApiResponse("Store updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteStore(@PathVariable Integer id){
        storeService.deleteStore(id);
        return ResponseEntity.ok(new ApiResponse("Store deleted successfully"));
    }


}
