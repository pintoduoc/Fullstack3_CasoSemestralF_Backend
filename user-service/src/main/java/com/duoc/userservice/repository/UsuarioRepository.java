package com.duoc.userservice.repository;

import com.duoc.userservice.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByRut(String rut);
}
