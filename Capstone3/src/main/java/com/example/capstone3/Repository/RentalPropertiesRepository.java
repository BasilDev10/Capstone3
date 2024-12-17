package com.example.capstone3.Repository;


import com.example.capstone3.Model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalPropertiesRepository extends JpaRepository<Rental, Integer> {

    Rental findRentalById(Integer rentalId);
}
