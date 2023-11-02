package com.SIGMA.entidade.DTO.tipo;

import com.SIGMA.entidade.Tipo;

import javax.validation.constraints.NotBlank;

public class TipoResponse {
    private String nome;
    private String descricao;

    public TipoResponse(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
    @Deprecated
    public TipoResponse() {
    }

    public TipoResponse(Tipo salvar) {
        this.descricao = salvar.getDescricao();
        this.nome = salvar.getNome();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
