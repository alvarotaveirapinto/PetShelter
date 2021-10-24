package com.example.backend_shelter.service;

import com.example.backend_shelter.repositories.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class AdoptionService {
    private final PetRepository petRepository;
    public AdoptionService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


//    public void addPetToRefugee(Pet pet) throws PetException {
//        if (this.checkIfPetIsOnRefugee(pet)) {
//            throw new PetException("Pet is already on database.");
//        }
//        this.petRepository.save(pet);
//    }
//    public boolean checkIfPetIsOnRefugee(Pet pet) {
//        return this.petRepository.existsById(pet.getId());
//    }
}

//    public void petAdoptedLeftRefugee(String name) throws PetException {
//        Pet pet = this.petRepository.findByPetName(name).orElseThrow(() -> new PetException(
//                String.format("%s was not found on our refugee!", name)
//        ));
//        this.petRepository.delete(pet);
//    }
