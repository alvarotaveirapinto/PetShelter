package com.example.backend_shelter.repositories;

import com.example.backend_shelter.models.Pet;
import com.example.backend_shelter.models.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findAllByPetType(PetType type);

    Optional<Pet> findByPetName(String name);
}


