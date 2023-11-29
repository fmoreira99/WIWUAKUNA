package com.sistemaexamenesbackend.sistemaexamenes.repository;

import com.sistemaexamenesbackend.sistemaexamenes.entitys.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface AnimalRespository extends JpaRepository<Animal, Long> {
    public Set<Animal> findByNameContainingAndDescriptionContaining(String name, String description);
    @Query("SELECT  u from Animal u WHERE u.name like %:nombre% or u.description like %:nombre%")
    public List<Animal> buscar(@Param("nombre") String nombre);
}
