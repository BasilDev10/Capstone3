package com.example.capstone3.Service;

import com.example.capstone3.ApiResponse.ApiException;
import com.example.capstone3.Model.Owner;
import com.example.capstone3.Model.Rental;
import com.example.capstone3.Model.RentalContract;
import com.example.capstone3.Repository.OwnerRepository;
import com.example.capstone3.Repository.RentalContractRepository;
import com.example.capstone3.Repository.RentalPropertiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalPropertiesService {

    private final RentalPropertiesRepository rentalPropertiesRepository;
    private final OwnerRepository ownerRepository;
    private final RentalContractRepository rentalContractRepository;


    //get all
    public List<Rental> getAllRental(){
         return rentalPropertiesRepository.findAll();
    }

    //insert
    public void add(Rental rental){
        Owner owner = ownerRepository.findOwnerById(rental.getOwner().getId());

        if (owner==null){
            throw new ApiException("Owner not found");
        }
        rental.setOwner(owner);
        rentalPropertiesRepository.save(rental);
    }

    //update

    public void updateRental(Integer id, Rental rental){
        Owner owner = ownerRepository.findOwnerById(rental.getOwner().getId());
        Rental rental1 = rentalPropertiesRepository.findRentalById(id);
        RentalContract rentalContract = rentalContractRepository.findRentalContractByRentalId(rental.getId());
        if (rentalContract.getContractStatus().equals("Active")){
            throw new ApiException("There is a valid contract for the property");
        }

        if (rental1==null){
            throw new ApiException("Rental Properties not found");
        }
        if (owner==null){
            throw new ApiException("Owner not found");
        }
        rental1.setName(rental.getName());
        rental1.setAvaiilableStatus(rental.getAvaiilableStatus());
        rental1.setCity(rental.getCity());
        rental1.setLocation(rental.getLocation());
        rental1.setArea(rental.getArea());
        rental1.setRentalType(rental.getRentalType());
        rental1.setRentalDuration(rental.getRentalDuration());
        rental1.setTotalRent(rental.getTotalRent());
        rental1.setLeaseTerm(rental.getLeaseTerm());
        rental1.setUnitType(rental.getUnitType());
        rental1.setFloor(rental.getFloor());
        rental1.setUnitAge(rental.getUnitAge());
        rental1.setUnitNumber(rental.getUnitNumber());
        rental1.setUnitArea(rental.getUnitArea());
        rental1.setUpdatedAt(rental.getUpdatedAt());

        rentalPropertiesRepository.save(rental1);
    }

    //delete
    public void deleteRental(Integer id){
        Rental rental = rentalPropertiesRepository.findRentalById(id);
        RentalContract rentalContract = rentalContractRepository.findRentalContractByRentalId(rental.getId());

        if (rentalContract.getContractStatus().equals("Active")){
            throw new ApiException("There is a valid contract for the property");
        }
        if (rental==null){
            throw new ApiException("Rental Properties not found");
        }
        rentalPropertiesRepository.delete(rental);
    }





}
