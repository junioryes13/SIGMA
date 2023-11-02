package com.SIGMA.entidade;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotBlank;

@Entity
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    public Tipo(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    @Deprecated
    public Tipo() {
    }


    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
