package com.SIGMA.controlador;

import com.SIGMA.entidade.DTO.user.UserRequest;
import com.SIGMA.entidade.DTO.user.UserResponse;
import com.SIGMA.entidade.User;
import com.SIGMA.security.servico.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    UsuarioServico usuarioServico;

    @GetMapping
    public List<UserResponse> Listar() {
        return usuarioServico.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> detalhe(@PathVariable Integer id) {
        Optional<User> user = usuarioServico.buscar(id);
        return user.isPresent() ? ResponseEntity.ok(new UserResponse(user.get()))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> salvar(@RequestBody @Valid UserRequest livro) {
        return ResponseEntity.ok(usuarioServico.salvar(livro));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@RequestBody @Valid UserRequest livro, @PathVariable Integer id) {
        return ResponseEntity.ok(usuarioServico.atualizar(id, livro));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable Integer id) {
        usuarioServico.deletar(id);
    }
}
