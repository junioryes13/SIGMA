package com.SIGMA.entidade.repositorio;

import com.SIGMA.entidade.User;
import com.SIGMA.security.JasyptAdvancedConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepositorio extends JpaRepository<User, Integer> {
    List<User> findByAtivoTrue();
}