package com.sistemaexamenesbackend.sistemaexamenes.Services;

import com.sistemaexamenesbackend.sistemaexamenes.entitys.Animal;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.User;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.UserAnimal;

import java.util.Set;

public interface IUserAnimal {
   public Set<Animal> buscarAnimalesDelUsuario(User user);
   public UserAnimal guardarRelacionUsuarioAnimal(UserAnimal relacion);


}
