package com.SIGMA.security.servico;

import com.SIGMA.entidade.Campus;
import com.SIGMA.entidade.repositorio.CampusRepositorio;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CampusServico {

    @Autowired
    private CampusRepositorio campusRepositorio;

    public List<Campus> listarTodos() {
        return campusRepositorio.findAll();
    }

    public Optional<Campus> buscarPorCodigo(Integer codigo) {
        return campusRepositorio.findById(codigo);
    }

    public Campus salvar(Campus campus) {
        return campusRepositorio.save(campus);
    }

    public Campus atualizar(Integer codigo, Campus campus) {
        Campus campusSalvar = validarCampusExiste(codigo);
        BeanUtils.copyProperties(campus, campusSalvar, "codigo");
        return campusRepositorio.save(campusSalvar);
    }

    public boolean deletar(Integer codigo) {
        if (buscarPorCodigo(codigo).isPresent()) {
            campusRepositorio.deleteById(codigo);
            return true;
        } else {
            return false;
        }
    }

    private Campus validarCampusExiste(Integer codigo) {
        Optional<Campus> categoria = Optional.empty();
        if (categoria.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return categoria.get();
    }
}
