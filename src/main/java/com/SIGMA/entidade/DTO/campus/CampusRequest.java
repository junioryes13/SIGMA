package com.SIGMA.entidade.DTO.campus;

import com.SIGMA.entidade.Campus;

import javax.validation.constraints.NotBlank;

public class CampusRequest {

    @NotBlank String nome;

    @NotBlank String cidade;

    public CampusRequest(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public Campus toModel() {
        return new Campus(nome,cidade);
    }
}
