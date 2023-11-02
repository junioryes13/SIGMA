package com.SIGMA.security.servico;

import com.SIGMA.entidade.Tipo;
import com.SIGMA.entidade.repositorio.TipoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoServico {

	@Autowired
	private TipoRepositorio tipoRepositorio;

	public List<Tipo> listarTodas() {
		return tipoRepositorio.findAll();
	}

	public Optional<Tipo> buscarPorCodigo(Integer codigo) {
		return tipoRepositorio.findById(codigo);
	}

    public Tipo salvar(Tipo tipo) {
	tipoRepositorio.save(tipo);
	return tipo;
    }
}