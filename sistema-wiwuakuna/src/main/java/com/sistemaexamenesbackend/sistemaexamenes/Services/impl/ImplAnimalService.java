package com.sistemaexamenesbackend.sistemaexamenes.Services.impl;

import com.sistemaexamenesbackend.sistemaexamenes.Services.AnimalService;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.Animal;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.dto.IncubacionDto;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.dto.ReponseStateAnimal;
import com.sistemaexamenesbackend.sistemaexamenes.repository.AnimalRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class ImplAnimalService implements AnimalService {
    @Autowired
    private AnimalRespository animalRespository;

    @Override
    public Animal guardarAnimal(Animal animal)  {
        return animalRespository.save(animal);
    }
    @Override
    public Animal obteneranimal(Long id)  {
        return animalRespository.findById(id).get();
    }
    public Animal validateDescripcion(Animal animal, String deString)
    {
        if(deString==null)
        {
            return animalRespository.save(animal);
        }else {
            animal.setIncubationDescription(deString);
            return animalRespository.save(animal);
        }
    }

    public String getReponseDescripcionAnimal(Integer Key)
    {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Animal dado de baja del sistema;  El animal ha sido dado de baja del sistema. No hay información disponible.");
        map.put(2, "Animal vendido; ¡Felicidades! El animal ha sido vendido y ahora tiene un nuevo hogar");
        map.put(3, "Animal en venta; Este animal está actualmente disponible para su compra.\n");
        map.put(4, "Animal hembra en proceso de gestación ; La hembra está actualmente en proceso de gestación. ¡Esperamos la llegada de crías pronto!");
        map.put(5, "Animal macho reproductor; Este animal es un macho reproductor, fundamental para nuestros programas de cría selectiva.");

        return map.get(Key);
    }

    @Override
    public ReponseStateAnimal state(IncubacionDto incubacionDto ) {
        Animal animal= animalRespository.findById(incubacionDto.getId()).get();
       animal.setIncubationdate(incubacionDto.getDate());
       animal.setState(incubacionDto.getState());
        animal= validateDescripcion(animal, incubacionDto.getDeString());
        String[] partesConPunto = getReponseDescripcionAnimal(incubacionDto.getState()).split(";");
        return ReponseStateAnimal.builder().animal(animal).tittelState(partesConPunto[0]).Message(partesConPunto[1])
                .build();
    }

    @Override
    public void delete(Long id) {
        animalRespository.deleteById(id);
    }

    @Override
    public List<Animal> ListPorTipoAnimal(String name)  {

        List<Animal> list= animalRespository.buscar(name);
        return list;
    }
    @Override
    public List<Animal> ListAnimal()  {
        List<Animal>  list= animalRespository.findAll();
        return list;
    }
}
