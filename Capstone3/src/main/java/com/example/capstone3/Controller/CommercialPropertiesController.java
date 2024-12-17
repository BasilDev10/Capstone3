package com.example.capstone3.Controller;

import com.example.capstone3.ApiResponse.ApiResponse;
import com.example.capstone3.Model.Rental;
import com.example.capstone3.Service.RentalPropertiesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/deal-hub/rental")
public class CommercialPropertiesController {

    private final RentalPropertiesService rentalPropertiesService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllRentalProperties(){
        return ResponseEntity.status(200).body(rentalPropertiesService.getAllRental());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRentalProperties(@RequestBody @Valid Rental rental){
        rentalPropertiesService.add(rental);
        return ResponseEntity.status(200).body(new ApiResponse("Rental shop added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRentalProperties(@PathVariable Integer id, @RequestBody @Valid Rental rental){
        rentalPropertiesService.updateRental(id,rental);
        return ResponseEntity.status(200).body(new ApiResponse("Rental shop updated successfully"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRentalProperties(@PathVariable Integer id){
        rentalPropertiesService.deleteRental(id);
        return ResponseEntity.status(200).body(new ApiResponse("Rental shop deleted successfully"));
    }






}
