package com.SIGMA.entidade.DTO.campus;

import com.SIGMA.entidade.Campus;

public class CampusResponse {

    String nome;
    String cidade;

    public CampusResponse(Campus salvar) {
        this.nome = salvar.getNome();
        this.cidade = salvar.getCidade();
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }
}
