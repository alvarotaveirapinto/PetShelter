package com.example.backend_shelter.controllers;

import com.example.backend_shelter.exception.ShelterException;
import com.example.backend_shelter.exception.UpdateShelterException;
import com.example.backend_shelter.models.Pet;
import com.example.backend_shelter.models.Shelter;
import com.example.backend_shelter.request.UpdateShelterRequest;
import com.example.backend_shelter.service.PetService;
import com.example.backend_shelter.service.ShelterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@ControllerAdvice
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

    @GetMapping(value = "/shelter/get/{id}")
    @ApiOperation(value = " Check if a shelter exists by id")
    public Shelter getById(@PathVariable("id") Integer id) throws ShelterException {
        return shelterService.getById(id);
    }
    @ExceptionHandler(value=ShelterException.class)
    public ResponseEntity<String> shelterIdNotFound (ShelterException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/put-edit/shelter/{id}")
    @ApiOperation(value = "Edit shelter by id")
    public ResponseEntity editShelterById(@PathVariable Long id, @RequestBody UpdateShelterRequest request) throws UpdateShelterException {
        final Shelter editShelterById = shelterService.editShelterById(id, request.getShelterName());
        return ResponseEntity.created(URI.create("/shelter" + id + "/name")).body("Updated Shelter Name");

    }

    @ExceptionHandler(value = UpdateShelterException.class)
    public ResponseEntity<String> updateShelter(UpdateShelterException exception) {
        return new ResponseEntity(exception.getMessage(),HttpStatus.NOT_FOUND);
    }










}
