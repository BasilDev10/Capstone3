package com.example.capstone3.Service;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalPropertiesService {

    private final RentalPropertiesRepository rentalPropertiesRepository;
    private final OwnerRepository ownerRepository;


    //get all
    public List<RentalShop> getAllRentalShops(){
         return rentalPropertiesRepository.findAll();
    }

    //insert shop info

    public void insertRntalShop(RentalShop rentalShop){
        Owner owner = ownerRepository.findOwnerByOwnerID(rentalShop.getOwner().getOwnerID());

        if (owner==null){
            throw new ApiException("Owner not found");
        }
    }



}
