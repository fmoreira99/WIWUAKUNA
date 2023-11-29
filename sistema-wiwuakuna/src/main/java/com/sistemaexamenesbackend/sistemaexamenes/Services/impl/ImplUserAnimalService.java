package com.sistemaexamenesbackend.sistemaexamenes.Services.impl;

import com.sistemaexamenesbackend.sistemaexamenes.Services.IUserAnimal;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.Animal;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.User;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.UserAnimal;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.UserRol;
import com.sistemaexamenesbackend.sistemaexamenes.repository.UserAnimalRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class ImplUserAnimalService implements IUserAnimal {
    @Autowired
    private UserAnimalRespository userAnimalRespository;
    @Override
    public Set<Animal> buscarAnimalesDelUsuario(User user) {
        Set<UserAnimal> listrAnimal=userAnimalRespository.findUserAnimalByUsuario(user);
        Set<Animal> listaAnimal= new HashSet<>();
        for(UserAnimal animal:listrAnimal)
        {
            listaAnimal.add(animal.getAnimal());
        }

        return listaAnimal;
    }
    @Override
    public UserAnimal guardarRelacionUsuarioAnimal(UserAnimal relacion) {
        return userAnimalRespository.save(relacion);
    }
}
