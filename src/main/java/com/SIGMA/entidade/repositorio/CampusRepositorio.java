package com.SIGMA.entidade.repositorio;

import com.SIGMA.entidade.Campus;
import com.SIGMA.entidade.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampusRepositorio extends JpaRepository<Campus, Integer> {
    Tipo findByNome (String Nome);

    Tipo findByCidade(String Nome);
}