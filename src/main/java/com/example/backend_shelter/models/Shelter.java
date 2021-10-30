package com.example.backend_shelter.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shelterId;
    private String shelterName;
    @Enumerated(EnumType.STRING)
    private ShelterSize shelterSize;

    @OneToMany
    private List<Pet> pets;
}
