package com.sistemaexamenesbackend.sistemaexamenes.Controller;

import com.sistemaexamenesbackend.sistemaexamenes.Services.RolService;
import com.sistemaexamenesbackend.sistemaexamenes.Services.UserService;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.Rol;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.User;
import com.sistemaexamenesbackend.sistemaexamenes.entitys.UserRol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("user/v1")
@CrossOrigin("*")
public class UserController  {
   @Autowired
   private  UserService userService;
   @Autowired
   private RolService rolService;
   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/save")
    public User GuardarUsuario(@RequestBody   User user) throws Exception {

        user.setPerfil("defauld.png");
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Set<UserRol> usuarioRoles = new HashSet<>();
        UserRol usuarioRol = new UserRol();
        usuarioRol.setRol(rolService.obtenerRol("ADMIN"));
        usuarioRol.setUsuario(user);
        usuarioRoles.add(usuarioRol);

      return userService.guardarUsuario(user, usuarioRoles);
    }

    @GetMapping(" /(username}")
    @Procedure(MediaType.APPLICATION_JSON_VALUE)
    public User obtenerUsuario(@PathVariable("username") String username) {
        return userService.ObtenerUsuario(username);
    }

    @GetMapping(" /(usuarioId}")
    public Boolean eliminarUserbyId(@PathVariable("usuarioId") Long userID) {
        return userService.eliminarUsuario(userID);
    }

}
