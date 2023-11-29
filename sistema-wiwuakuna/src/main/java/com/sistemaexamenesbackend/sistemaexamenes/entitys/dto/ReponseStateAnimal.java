package com.sistemaexamenesbackend.sistemaexamenes.entitys.dto;

import com.sistemaexamenesbackend.sistemaexamenes.entitys.Animal;
import lombok.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReponseStateAnimal {
        private Animal animal;
        private String tittelState;
        private String Message;

}
