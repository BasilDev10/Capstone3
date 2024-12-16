package com.example.capstone3.Repository;

import com.example.capstone3.Model.CommercialProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommercialPropertiesRepository extends JpaRepository<CommercialProperties, Integer> {
}
