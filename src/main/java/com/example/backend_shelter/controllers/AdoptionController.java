package com.example.backend_shelter.controllers;

import com.example.backend_shelter.exception.PetException;
import com.example.backend_shelter.models.Pet;
import com.example.backend_shelter.service.PetService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@ControllerAdvice
public class AdoptionController {
    @Autowired
    private PetService petService;

    @GetMapping(value = "/pets")
    @ApiOperation(value = "Get all pet")
    public List<Pet> getPet() {
        return petService.findAll();
    }

    @PostMapping(value="/pet")
    @ApiOperation(value = "Add a pet")
    public Pet addPet(@RequestBody Pet pet) throws PetException {
        return petService.save(pet);
    }
    @ExceptionHandler(PetException.class)
    public ResponseEntity<String> petNotFoundException(PetException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/pet/{id}")
    @ApiOperation(value = "Get Pet by Id")
    public Optional<Pet> getPet(@PathVariable("id") Long id){
        return petService.findbyId(id);
    }

    @GetMapping(value="/pet/type/{type}")
    @ApiOperation(value = "Get Pet by type")
    public List<Pet> getPetByType(@PathVariable String type){
        return petService.findAllByType(type);
    }

    @GetMapping(value="/pet/name/{name}")
    @ApiOperation(value = "Get Pet by Name")
    public Pet getPetByName(@PathVariable String name){
        return petService.findByName(name);
    }






}
