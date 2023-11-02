package com.SIGMA.entidade.repositorio;

import com.SIGMA.entidade.Campus;
import com.SIGMA.entidade.DTO.user.UserResponse;
import com.SIGMA.entidade.OrdemDeServico;
import com.SIGMA.entidade.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface OrdemDeServicoRepositorio extends JpaRepository<OrdemDeServico, Integer> {


    ResponseEntity<UserResponse> findByStatusNot(String status);
    ResponseEntity<UserResponse> findByStatus(String concluido);
}