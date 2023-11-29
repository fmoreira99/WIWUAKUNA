package com.sistemaexamenesbackend.sistemaexamenes.entitys.dto;

import com.sistemaexamenesbackend.sistemaexamenes.entitys.typeAnimal;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDto {

    private Long id;
    private String name;
    private String description;
    private Integer countAnimal;
    private Double price;
    private String dateRegistre;
    private String genero;
    private Long tipo;
    private Date incubationdate;
    private String  incubationDescription;
    private Integer incubationState;
}
