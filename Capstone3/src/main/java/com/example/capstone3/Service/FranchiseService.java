package com.example.capstone3.Service;

import com.example.capstone3.ApiResponse.ApiException;
import com.example.capstone3.Model.Franchise;
import com.example.capstone3.Model.FranchiseContracts;
import com.example.capstone3.Repository.FranchiseContractRepository;
import com.example.capstone3.Repository.FranchiseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class  FranchiseService {

    private final FranchiseRepository franchiseRepository;
    private final FranchiseOfferService franchiseOfferService;
    private final FranchiseContractRepository franchiseContractRepository;


    public void add(Franchise franchise){
        franchiseRepository.save(franchise);

    }

    public void update(Integer id,Franchise franchise){
        Franchise oldFranchise = franchiseRepository.findFranchiseById(id);

        oldFranchise.setBrandName(franchise.getBrandName());
        oldFranchise.setLicenseNumber(franchise.getLicenseNumber());
        oldFranchise.setContractDuration(franchise.getContractDuration());
        oldFranchise.setInvestmentAmount(franchise.getInvestmentAmount());
        oldFranchise.setFranchiseFee(franchise.getFranchiseFee());
        oldFranchise.setNumberOfBranches(franchise.getNumberOfBranches());
        oldFranchise.setCountryOfOrigin(franchise.getCountryOfOrigin());
        oldFranchise.setFranchiseType(franchise.getFranchiseType());
        oldFranchise.setSector(franchise.getSector());
        oldFranchise.setOngoingAdminFees(franchise.getOngoingAdminFees());
        oldFranchise.setDescription(franchise.getDescription());
        oldFranchise.setSupportDetails(franchise.getSupportDetails());

    }



    public void delete(Integer id){
        FranchiseContracts franchiseContracts = franchiseContractRepository.findFranchiseContractsByFranchiseIdAndStatus(id, "Active");

        if (franchiseContracts != null) {
            throw new ApiException("Cannot delete franchise with active contracts");
        }

        Franchise franchise = franchiseRepository.findFranchiseById(id);

        franchiseRepository.delete(franchise);
    }

}
