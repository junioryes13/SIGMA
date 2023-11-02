package com.SIGMA.controlador;


import com.SIGMA.entidade.DTO.equipamento.EquipamentoRequest;
import com.SIGMA.entidade.DTO.equipamento.EquipamentoResponse;
import com.SIGMA.entidade.Equipamento;
import com.SIGMA.security.servico.EquipamentoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoControlador {

    @Autowired
    EquipamentoServico equipamentoServico;

    @GetMapping
    public ResponseEntity<List<Equipamento>> buscarPorId() {
        return ResponseEntity.ok(equipamentoServico.buscarTodos());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Equipamento> buscarPorId(@PathVariable Integer codigo) throws Exception {
        return equipamentoServico.buscar(codigo).isPresent() ? ResponseEntity.ok(equipamentoServico.buscar(codigo).get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EquipamentoResponse> Salvar(@Valid @RequestBody EquipamentoRequest request) {
        return ResponseEntity.ok().body(new EquipamentoResponse(equipamentoServico.salvar(request)));
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<EquipamentoResponse> atualizar (@Valid @PathVariable int id, @RequestBody EquipamentoRequest form){
       Equipamento equipamentoNovo = equipamentoServico.atualizar(id, form);
            return ResponseEntity.ok(new EquipamentoResponse(equipamentoNovo));
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable int id){
        equipamentoServico.deletar(id);
    }
}
