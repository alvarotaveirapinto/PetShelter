package com.example.backend_shelter.service;

import com.example.backend_shelter.repositories.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetInformationService {

    private final PetRepository petRepository;

    public PetInformationService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


}
