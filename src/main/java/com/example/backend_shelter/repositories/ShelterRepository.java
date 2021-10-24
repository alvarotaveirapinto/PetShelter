package com.example.backend_shelter.repositories;

import com.example.backend_shelter.models.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelterRepository extends JpaRepository<Shelter, Integer> {

    Shelter findByShelterName(String name);
}
