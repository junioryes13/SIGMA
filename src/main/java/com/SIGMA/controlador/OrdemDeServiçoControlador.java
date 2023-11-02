package com.SIGMA.controlador;

import com.SIGMA.entidade.DTO.Os.OSRequest;
import com.SIGMA.entidade.DTO.Os.OSResponse;
import com.SIGMA.entidade.DTO.user.UserResponse;
import com.SIGMA.entidade.OrdemDeServico;
import com.SIGMA.security.servico.OrdemDeServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/OrdemDeServico")
public class OrdemDeServiçoControlador {

    @Autowired
    private OrdemDeServicoService OSservice;

    @GetMapping("/listar")
    public List<OrdemDeServico> Listar() {
        return OSservice.listarTodos();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<OSResponse> buscar(@PathVariable Integer id) {
        Optional<OrdemDeServico> os = OSservice.buscar(id);
        return os.isPresent() ? ResponseEntity.ok(new OSResponse(os.get()))
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/concluidas")
    public ResponseEntity<UserResponse> concluidas(@PathVariable Integer id) {
        return OSservice.buscarConcluidas();
    }

    @GetMapping("/abertas")
    public ResponseEntity<UserResponse> abertas(@PathVariable Integer id) {
        return OSservice.buscarAbertas();
    }


    @PostMapping("/new")
    @Transactional
    public ResponseEntity<?> salvar(@RequestBody @Valid OSRequest os) {
        return ResponseEntity.ok(OSservice.salvar(os));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@RequestBody @Valid OSRequest os, @PathVariable Integer id) {
        return ResponseEntity.ok(OSservice.atualizar(id, os));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable Integer id) {
        OSservice.deletar(id);
    }

}
