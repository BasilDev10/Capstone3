package com.example.capstone3.Repository;

import com.example.capstone3.Model.FranchiseContracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  FranchiseContractRepository extends JpaRepository<FranchiseContracts, Integer> {

    FranchiseContracts findFranchiseContractById(Integer id);

    FranchiseContracts findFranchiseContractsByFranchiseIdAndStatus(Integer franchiseId, String status);


}
