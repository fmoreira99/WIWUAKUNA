package com.sistemaexamenesbackend.sistemaexamenes.repository;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.Animal;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.typeAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface TypeAnimalRepository extends JpaRepository<typeAnimal, Long> {


}
