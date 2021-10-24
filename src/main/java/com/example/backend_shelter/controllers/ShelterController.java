package com.example.backend_shelter.controllers;

import com.example.backend_shelter.models.Pet;
import com.example.backend_shelter.models.Shelter;
import com.example.backend_shelter.service.PetService;
import com.example.backend_shelter.service.ShelterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShelterController {

    @Autowired
    private ShelterService shelterService;

    @Autowired
    private PetService petService;

    @PostMapping(value="/shelter/add")
    @ApiOperation(value = "Add a new shelter")
    public Shelter addShelter(@RequestBody Shelter shelter)  {
        return shelterService.saveShelter(shelter);
    }

    @DeleteMapping(value = "/shelter/delete/{id}")
    @ApiOperation(value = "Delete shelter BY ID")
    public String deleteShelterById(@PathVariable Integer id){
        return shelterService.deleteShelterById(id);
    }

    @PostMapping(value="/pet/add-to-shelter/{shelterId}")
    @ApiOperation(value = "Add a new pet to shelter")
    public Pet addPetToShelter(@RequestBody Pet pet, @PathVariable Integer shelterId)  {
        return petService.savePetToShelter(pet, shelterId);
    }
    @GetMapping(value="/get-shelter/name/{name}")
    @ApiOperation(value="Find shelter by name")
    public Shelter getShelterByName(@PathVariable String name)  {
        return shelterService.findByName(name);
    }


}
