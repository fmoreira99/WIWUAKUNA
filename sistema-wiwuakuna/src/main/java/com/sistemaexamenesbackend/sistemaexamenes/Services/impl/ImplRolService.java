package com.sistemaexamenesbackend.sistemaexamenes.Services.impl;

import com.sistemaexamenesbackend.sistemaexamenes.Services.RolService;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.Rol;
import com.sistemaexamenesbackend.sistemaexamenes.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplRolService implements RolService {
    @Autowired
    private RolRepository rolRepository;
    @Override
    public Rol obtenerRol(String nombreRol) {
        Rol rol= rolRepository.findByNombre(nombreRol);
        return rol;
    }
}
