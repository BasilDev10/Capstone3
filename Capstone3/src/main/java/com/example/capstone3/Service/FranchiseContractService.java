package com.example.capstone3.Service;

import com.example.capstone3.Model.FranchiseContracts;
import com.example.capstone3.Repository.FranchiseContractRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


// Done by salem
@Service
@AllArgsConstructor
public class  FranchiseContractService {

    private final FranchiseContractRepository franchiseContractRepository;


    public List<FranchiseContracts> getActiveContracts(Integer individualId) {

        return franchiseContractRepository.findFranchiseContractsByIndividualIdAndStatus(individualId,"Active");
    }

    public List<FranchiseContracts> getExpiredContracts(Integer individualId) {

        return franchiseContractRepository.findFranchiseContractsByIndividualIdAndStatus(individualId,"Expired");
    }


    public List<FranchiseContracts> getActiveContractsOwner(Integer ownerId) {

        return franchiseContractRepository.findFranchiseContractsByOwnerIdAndStatus(ownerId,"Active");
    }

    public List<FranchiseContracts> getExpiredContractsOwner(Integer ownerId) {

        return franchiseContractRepository.findFranchiseContractsByOwnerIdAndStatus(ownerId,"Expired");
    }
}
