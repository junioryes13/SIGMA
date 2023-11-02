package com.SIGMA.entidade.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.SIGMA.entidade.Equipamento;


public interface EquipamentoRepositorio extends JpaRepository<Equipamento, Integer> {
    List<Equipamento> findByCampusCodigo(int id);
    List<Equipamento> findByTipoCodigo(int id);
}
	
	

