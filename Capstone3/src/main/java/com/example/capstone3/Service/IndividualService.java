package com.example.capstone3.Service;


import com.example.capstone3.ApiResponse.ApiException;
import com.example.capstone3.Model.Individual;
import com.example.capstone3.Repository.IndividualRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IndividualService {

    private final IndividualRepository individualRepository;



    public void addIndividual(Individual individual) {
       individualRepository.save(individual);
    }


    public void updateIndividual(Integer id,Individual individual)
    {
            Individual oldIndividual = individualRepository.findIndividualById(id);
            if(oldIndividual == null) {
                throw new ApiException("individual not found");

            }
            oldIndividual.setEmail(individual.getEmail());
            oldIndividual.setFullName(individual.getFullName());
            oldIndividual.setPhoneNumber(individual.getPhoneNumber());
            individualRepository.save(oldIndividual);
    }
}

