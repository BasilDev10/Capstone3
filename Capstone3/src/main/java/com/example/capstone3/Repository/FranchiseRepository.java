package com.example.capstone3.Repository;

import com.example.capstone3.Model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise,Integer> {

    Franchise findFranchiseById(Integer id);

}
