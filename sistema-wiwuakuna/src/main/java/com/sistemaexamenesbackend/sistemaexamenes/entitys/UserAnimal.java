package com.sistemaexamenesbackend.sistemaexamenes.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
@Entity
@Table(name = "useranimal")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    private Long userAnimalId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private User usuario;
    @ManyToOne
    @JsonIgnore
    private Animal animal;
}
