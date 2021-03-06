package com.example.backend_shelter.service;

import com.example.backend_shelter.exception.ShelterException;
import com.example.backend_shelter.exception.UpdateShelterException;
import com.example.backend_shelter.models.Shelter;
import com.example.backend_shelter.repositories.ShelterRepository;
import org.springframework.stereotype.Service;

@Service
public class ShelterService {

    private ShelterRepository shelterRepository;

    public ShelterService(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    public Shelter saveShelter(Shelter shelter) {
        return shelterRepository.save(shelter);
    }
    public String deleteShelterById(Integer id) {
        shelterRepository.deleteById(id);
        return "Shelter Deleted";
    }

    public Shelter findByName(String name) {
        Shelter shelter = shelterRepository.findByShelterName(name);
        return shelter;

    }

    public Shelter getById(Integer id) throws ShelterException {
        if(shelterRepository.existsById(id)) {
            return shelterRepository.getById(id);
        }
        else {
            throw new ShelterException("SHELTER ID NOT FOUND " + id);
        }

    }


    public Shelter editShelterById(Long id, String shelterName) {
        Shelter shelter = shelterRepository.findById(Math.toIntExact(id)).orElseThrow(
                () -> new UpdateShelterException("Shelter Id not Found"));
        return shelter;

    }
}

