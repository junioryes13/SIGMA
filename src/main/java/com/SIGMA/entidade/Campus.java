package com.SIGMA.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int codigo;

    @NotBlank String nome;

    @NotBlank String cidade;

    public Campus(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    @Deprecated
    public Campus() {
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }
}