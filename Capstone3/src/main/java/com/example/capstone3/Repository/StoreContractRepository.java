package com.example.capstone3.Repository;

import com.example.capstone3.Model.StoreContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreContractRepository extends JpaRepository<StoreContract, Integer> {

    StoreContract findStoreContractById(Integer storeContractId);

    StoreContract findStoreContractByStoreId(Integer id);
}
