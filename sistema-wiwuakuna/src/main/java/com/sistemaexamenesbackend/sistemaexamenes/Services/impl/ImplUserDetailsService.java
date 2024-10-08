package com.sistemaexamenesbackend.sistemaexamenes.Services.impl;

import com.sistemaexamenesbackend.sistemaexamenes.entitys.User;
import com.sistemaexamenesbackend.sistemaexamenes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ImplUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepository.findByUsername(username);

        if(user==null)
        {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return user;
    }
}
