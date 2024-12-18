package com.example.capstone3.Repository;

import com.example.capstone3.Model.FranchiseOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// Done by Salem
public interface  FranchiseOfferRepository extends JpaRepository<FranchiseOffer,Integer> {

    FranchiseOffer findFranchiseOfferById(Integer id);

    FranchiseOffer findFranchiseOfferByFranchiseIdAndStatus(Integer franchiseId, String status);

    List<FranchiseOffer> findFranchiseOfferByIndividualIdAndStatus(Integer individualId, String status);

    FranchiseOffer findFranchiseOfferByFranchiseIdAndIndividualId(Integer franchiseId, Integer individualId);


}
