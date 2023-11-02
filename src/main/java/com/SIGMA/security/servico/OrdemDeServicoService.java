package com.SIGMA.security.servico;

import com.SIGMA.entidade.DTO.Os.OSRequest;
import com.SIGMA.entidade.DTO.Os.OSResponse;
import com.SIGMA.entidade.DTO.user.UserResponse;
import com.SIGMA.entidade.Equipamento;
import com.SIGMA.entidade.OrdemDeServico;
import com.SIGMA.entidade.repositorio.OrdemDeServicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrdemDeServicoService {


    @Autowired
    OrdemDeServicoRepositorio ordemDeServicoRepositorio;

    public List<OrdemDeServico> listarTodos() {
        return ordemDeServicoRepositorio.findAll();
    }

    public Optional<OrdemDeServico> buscar(Integer id) {

        return ordemDeServicoRepositorio.findById(id);

    }

    public ResponseEntity<UserResponse> buscarConcluidas() {
    return ordemDeServicoRepositorio.findByStatus("CONCLUIDO");
    }

    public ResponseEntity<UserResponse> buscarAbertas() {
        return ordemDeServicoRepositorio.findByStatusNot("CONCLUIDO");
    }

    public OSResponse salvar(OSRequest os) {
        OrdemDeServico osObject = new OrdemDeServico(os);
        ordemDeServicoRepositorio.save(osObject);
        return new OSResponse(osObject);
    }

    public Object atualizar(int id, OSRequest os) {
        OrdemDeServico ordem = ordemDeServicoRepositorio.findById(id).get();

        //ordem.atualizar(form);
        //ordem.save(equipamento);
        return ordem;

    }

    public void deletar(Integer id) {
        Optional<OrdemDeServico> ordem = ordemDeServicoRepositorio.findById(id);
        if (ordem.isPresent()) {
            ordem.get().inativar();
        }
    return;
    }
}
