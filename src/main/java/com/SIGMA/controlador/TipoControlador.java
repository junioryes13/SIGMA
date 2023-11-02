package com.SIGMA.controlador;

import java.util.List;
import java.util.Optional;

import com.SIGMA.entidade.DTO.tipo.TipoRequest;
import com.SIGMA.entidade.DTO.tipo.TipoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.SIGMA.entidade.Tipo;
import com.SIGMA.security.servico.TipoServico;

import javax.validation.Valid;

@RestController
@RequestMapping("/tipo")
public class TipoControlador {

	@Autowired
	private TipoServico tipoServico;

	@GetMapping
	public List<Tipo> listarTodos() {

		return tipoServico.listarTodas();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Tipo> buscarPorId(@PathVariable int codigo) {

		Optional<Tipo> tipo = tipoServico.buscarPorCodigo(codigo);
		return tipo.isPresent() ? ResponseEntity.ok(tipo.get()) : ResponseEntity.notFound().build();

	}
	@PostMapping
	public ResponseEntity<TipoResponse> Salvar(@Valid @RequestBody TipoRequest request) {
		Tipo tipo = request.toModel();
		return ResponseEntity.ok().body(new TipoResponse(tipoServico.salvar(tipo)));
	}
}
