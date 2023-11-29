package com.sistemaexamenesbackend.sistemaexamenes.repository;

import com.sistemaexamenesbackend.sistemaexamenes.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);


}
