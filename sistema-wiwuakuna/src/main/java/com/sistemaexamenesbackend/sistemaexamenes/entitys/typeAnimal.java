package com.sistemaexamenesbackend.sistemaexamenes.entitys;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="typeAnimal")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class typeAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeName;
    @OneToMany(mappedBy = "tipo")
    private List<Animal> animales;

}
