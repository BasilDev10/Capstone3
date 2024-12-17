package com.example.capstone3.Service;

import com.example.capstone3.ApiResponse.ApiException;
import com.example.capstone3.Model.Owner;
import com.example.capstone3.Repository.OwnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public void add(Owner owner){
        ownerRepository.save(owner);
    }

    public  void update(Integer id,Owner owner){
        Owner oldOwner = ownerRepository.findOwnerById(id);

        if (oldOwner == null){
            throw new ApiException("Owner not found");
        }

        oldOwner.setEmail(owner.getEmail());
        oldOwner.setFullName(owner.getFullName());
        oldOwner.setPhoneNumber(owner.getPhoneNumber());
        ownerRepository.save(oldOwner);
    }


}
