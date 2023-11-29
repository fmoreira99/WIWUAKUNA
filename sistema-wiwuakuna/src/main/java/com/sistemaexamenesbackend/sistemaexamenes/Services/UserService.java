package com.sistemaexamenesbackend.sistemaexamenes.Services;

import com.sistemaexamenesbackend.sistemaexamenes.entitys.User;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.UserRol;

import java.util.List;
import java.util.Set;

public interface UserService {
    public User guardarUsuario(User usuario, Set<UserRol> userRolSet) throws Exception;
    public User ObtenerUsuario(String username);
    public Boolean eliminarUsuario(Long usuarioId);
    public List<User> ListUser();
}
