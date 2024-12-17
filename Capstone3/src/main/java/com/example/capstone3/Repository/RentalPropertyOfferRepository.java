package com.example.capstone3.Repository;


import com.example.capstone3.Model.RentalOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalPropertyOfferRepository extends JpaRepository<RentalOffer, Integer> {
}
