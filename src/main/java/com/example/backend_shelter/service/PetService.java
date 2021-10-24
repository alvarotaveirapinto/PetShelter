package com.example.backend_shelter.service;

import com.example.backend_shelter.exception.PetException;
import com.example.backend_shelter.models.Pet;
import com.example.backend_shelter.models.PetType;
import com.example.backend_shelter.models.Shelter;
import com.example.backend_shelter.repositories.PetRepository;
import com.example.backend_shelter.repositories.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    PetRepository petRepository;

    @Autowired
    private ShelterRepository shelterRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }



    public Optional<Pet> findbyId(Long id) {
        return petRepository.findById(id);
    }

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> findAllByType(String type) {
        return petRepository.findAllByPetType(PetType.valueOf(type.toUpperCase()));
    }

    public Pet findByName(String name) {
        Pet pet = petRepository.findByPetName(name).orElseThrow(
                ()-> new PetException("PET NOT FOUND  FOR THE GIVEN NAME : " + name)
        );
        return pet;
    }
    public Pet savePetToShelter(Pet pet, Integer shelterId) {
        Shelter shelter = shelterRepository.findById(shelterId).orElseThrow(
                () -> new PetException("SHELTER NOT FOUND WITH ID  " + shelterId)
        );
        Pet pet1 = petRepository.save(pet);
        shelter.getPets().add(pet1);
        shelterRepository.save(shelter);
        return pet;

    }
}



