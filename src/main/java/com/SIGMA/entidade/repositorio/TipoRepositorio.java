package com.SIGMA.entidade.repositorio;

import com.SIGMA.entidade.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public interface TipoRepositorio extends JpaRepository<Tipo, Integer>{
	Tipo findByNome(String Nome);
	
}
