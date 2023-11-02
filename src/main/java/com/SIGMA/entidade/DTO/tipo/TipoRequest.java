package com.SIGMA.entidade.DTO.tipo;

import com.SIGMA.entidade.Tipo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class TipoRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    public TipoRequest(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    @Deprecated
    public TipoRequest() {
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Tipo toModel() {

    return new Tipo(this.nome, this.descricao);}
}
