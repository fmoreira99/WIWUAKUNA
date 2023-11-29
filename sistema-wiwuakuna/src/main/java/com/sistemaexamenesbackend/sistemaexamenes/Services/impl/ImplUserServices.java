package com.sistemaexamenesbackend.sistemaexamenes.Services.impl;

import com.sistemaexamenesbackend.sistemaexamenes.Services.UserService;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.User;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.UserRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistemaexamenesbackend.sistemaexamenes.repository.RolRepository;
import com.sistemaexamenesbackend.sistemaexamenes.repository.UserRepository;

import java.util.List;
import java.util.Set;
@Service
public class ImplUserServices implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolRepository rolRepository;
    @Override
    public User guardarUsuario(User usuario, Set<UserRol> userRolSet) throws Exception {
        User user= userRepository.findByUsername(usuario.getUsername());
        if(user!=null)
        {
            System.out.println("El usuario ya exite");
            throw  new Exception("El usuario ya existe");
        }else {
            for(UserRol usuarioRol:userRolSet)
            {
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUserRolSet().addAll(userRolSet);
            user = userRepository.save(usuario);
        }
        return user;
    }

    @Override
    public User ObtenerUsuario(String username) {
        return  userRepository.findByUsername(username);
    }
    @Override
    public Boolean eliminarUsuario(Long usuarioId) {
        userRepository.deleteById(usuarioId);
        return userRepository.existsById(usuarioId);
    }

    @Override
    public List<User> ListUser() {
        List<User>  list= userRepository.findAll();
        return list;
    }
}
