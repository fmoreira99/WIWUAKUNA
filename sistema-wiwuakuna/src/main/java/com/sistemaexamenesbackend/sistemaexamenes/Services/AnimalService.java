package com.sistemaexamenesbackend.sistemaexamenes.Services;

import com.sistemaexamenesbackend.sistemaexamenes.entitys.Animal;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.User;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.UserAnimal;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.UserRol;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.dto.IncubacionDto;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.dto.ReponseStateAnimal;

import java.util.List;
import java.util.Set;

public interface AnimalService {
    public Animal guardarAnimal(Animal animal) throws Exception;
    public Animal obteneranimal(Long id);
    public ReponseStateAnimal state(IncubacionDto incubacionDto);
    public void delete(Long id);

    public List<Animal> ListAnimal() ;
    public List<Animal> ListPorTipoAnimal(String name) ;
}
