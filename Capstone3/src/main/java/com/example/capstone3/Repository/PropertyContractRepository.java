package com.example.capstone3.Repository;

import com.example.capstone3.Model.PropertyContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyContractRepository extends JpaRepository<PropertyContract, Integer> {
}
