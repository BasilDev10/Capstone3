package com.example.capstone3.Repository;


import com.example.capstone3.Model.RentalContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalContractRepository extends JpaRepository<RentalContract, Integer> {

    RentalContract findRentalContractById(Integer rentalContractId);

    RentalContract findRentalContractByRentalId(Integer rentalId );
}
