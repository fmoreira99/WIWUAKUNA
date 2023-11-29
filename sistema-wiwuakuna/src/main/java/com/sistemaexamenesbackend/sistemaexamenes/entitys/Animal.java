package com.sistemaexamenesbackend.sistemaexamenes.entitys;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.ws.rs.DefaultValue;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="animal")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(name = "count_animal")
    private Integer countAnimal;
   // private Double price;
    @Column(name = "date_registre")
    private String dateRegistre;
    private String genero;
    @ManyToOne
    @JoinColumn(name = "type_animal_id")
    @JsonIgnore
    private typeAnimal tipo;
   private String incubation_state;
    private String incubationdate;
    @Column(name = "incubation_description")
    private String  incubationDescription;
    private Integer State;
    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "animal")
    @JsonIgnore
    private Set<UserAnimal> userAnimals= new HashSet<>();



}
