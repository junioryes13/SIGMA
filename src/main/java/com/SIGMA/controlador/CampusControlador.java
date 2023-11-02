package com.SIGMA.controlador;

import com.SIGMA.entidade.Campus;
import com.SIGMA.entidade.DTO.campus.CampusRequest;
import com.SIGMA.entidade.DTO.campus.CampusResponse;
import com.SIGMA.security.servico.CampusServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/campus")
public class CampusControlador {

    @Autowired
    private CampusServico campusServico;

    @GetMapping
    public List<Campus> listarTodos() {
        return campusServico.listarTodos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Campus> buscarPorId(@PathVariable Integer codigo) {
        Optional<Campus> campus = campusServico.buscarPorCodigo(codigo);
        return campus.isPresent() ? ResponseEntity.ok(campus.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CampusResponse> Salvar(@Valid @RequestBody CampusRequest request) {
        Campus campus = request.toModel();
        return ResponseEntity.ok().body(new CampusResponse(campusServico.salvar(campus)));
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> Deletar(@Valid @PathVariable Integer codigo){
        if(campusServico.deletar(codigo)){
        return (ResponseEntity) ResponseEntity.noContent();
    }else{
            return (ResponseEntity) ResponseEntity.badRequest();
        }
    }
}
