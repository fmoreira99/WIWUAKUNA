package com.sistemaexamenesbackend.sistemaexamenes.repository;

import com.sistemaexamenesbackend.sistemaexamenes.entitys.Rol;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository  extends JpaRepository<Rol, Long> {
    public Rol findByNombre(String nombre);
}
