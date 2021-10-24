package com.example.backend_shelter.service;

import com.example.backend_shelter.repositories.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class AdoptionService {
    private final PetRepository petRepository;
    public AdoptionService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }}


