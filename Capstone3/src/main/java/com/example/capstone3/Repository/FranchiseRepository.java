package com.example.capstone3.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository {

    Franchise findFranchiseById(Integer id);

}
