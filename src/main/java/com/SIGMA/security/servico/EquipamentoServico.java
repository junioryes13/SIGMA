package com.SIGMA.security.servico;


import com.SIGMA.entidade.DTO.equipamento.EquipamentoRequest;
import com.SIGMA.entidade.Equipamento;
import com.SIGMA.entidade.repositorio.CampusRepositorio;
import com.SIGMA.entidade.repositorio.EquipamentoRepositorio;
import com.SIGMA.entidade.repositorio.TipoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoServico {

    @Autowired
    EquipamentoRepositorio equipamentoRepositorio;

    @Autowired
    CampusRepositorio campusRepositorio;

    @Autowired
    TipoRepositorio tipoRepositorio;


    public Equipamento salvar(EquipamentoRequest request) {
        System.out.println(request.getTipo());
        System.out.println(request.getCampus());
        Equipamento equipamento = new Equipamento(request.getSerial(),
                tipoRepositorio.findById(request.getTipo()).get(),
                campusRepositorio.findById(request.getCampus()).get(),
                request.getDescricao(),
                request.getObservacao());
        return equipamentoRepositorio.save(equipamento);
    }

    public Optional<Equipamento> buscar(int id) throws Exception {
        return equipamentoRepositorio.findById(id);
    }

    public List<Equipamento> buscarTodos(){
        return equipamentoRepositorio.findAll();
    }

    public List<Equipamento> buscarCampus(int idCampus){
        return equipamentoRepositorio.findByCampusCodigo(idCampus);
    }

    public List<Equipamento> buscarTipo(int idTipo){
        return equipamentoRepositorio.findByTipoCodigo( idTipo);
    }


    public Equipamento atualizar(int id, EquipamentoRequest form) {

       Equipamento equipamento = equipamentoRepositorio.findById(id).get();
        if(form.getCampus()  != equipamento.getCampus().getCodigo()){

           equipamento.setCampus(campusRepositorio.findById(form.getCampus()).get());

        }
        if(form.getTipo() != equipamento.getTipo().getCodigo()) {
            equipamento.setTipo(tipoRepositorio.findById(form.getTipo()).get());
        }
       equipamento.atualizar(form);
       equipamentoRepositorio.save(equipamento);
        return equipamento;
    }

    public void deletar(int id) {
        Optional<Equipamento> equipamento = equipamentoRepositorio.findById(id);
        if (equipamento.isPresent()) {
            equipamento.get().inativar();
        }
    }
}
