package com.example.backend_shelter.models;

import javax.persistence.*;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @Enumerated(EnumType.STRING)
    private PetType petType;
    private String petName;

    public Pet() {
    }

    public Pet(Long id, PetType petType, String petName) {
        this.id = id;
        this.petType = petType;
        this.petName = petName;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public PetType getPetType() {
        return petType;
    }
    public void setPetType(PetType petType) {
        this.petType = petType;
    }
    public String getPetName() {
        return petName;
    }
    public void setPetName(String petName) {
        this.petName = petName;
    }
}
