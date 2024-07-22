package com.example.exercicioii.modules.repository;


import com.example.exercicioii.modules.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findById(long id);
    void deleteById(long id);
}
