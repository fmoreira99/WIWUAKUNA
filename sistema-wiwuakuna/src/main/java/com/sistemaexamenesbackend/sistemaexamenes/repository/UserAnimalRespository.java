package com.sistemaexamenesbackend.sistemaexamenes.repository;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.User;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.UserAnimal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserAnimalRespository extends JpaRepository<UserAnimal, Long> {
    public Set<UserAnimal> findUserAnimalByUsuario(User user);

}
