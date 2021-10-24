package com.example.backend_shelter.models;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime lunchTime;
    @OneToOne
    private Food food;
    @OneToOne
    private Pet pet;
}
