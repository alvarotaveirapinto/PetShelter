package com.example.backend_shelter.service;

import com.example.backend_shelter.models.Pet;
import com.example.backend_shelter.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetInformationService {

    private final PetRepository petRepository;

    public PetInformationService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    public Set<Pet> getAllPets() {
        return Set.copyOf(this.petRepository.findAll());
    }








//    public Set<Pet> getAllDogs() {
//        return this.petRepository.findByPetType(PetType.DOG);
//    }
//
//    public Set<Pet> getAllCats() {
//        return this.petRepository.findByPetType(PetType.CAT);
//    }
//
//    public Set<Pet> getAllEagles() {
//        return this.petRepository.findByPetType(PetType.EAGLE);
//    }
}
