package com.SIGMA.entidade;

import com.SIGMA.entidade.DTO.equipamento.EquipamentoRequest;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Length(max = 30)
    private String serial;

    @NotNull
    @ManyToOne
    private Campus campus;

    @NotBlank
    private String descricao;

    @NotNull
    @ManyToOne
    private Tipo tipo;

    @NotBlank
    private String observacao;


    boolean ativo = true;

    public Equipamento(String serial, Tipo tipo, Campus campus, String descricao, String observacao) {
        this.serial = serial;
        this.campus = campus;
        this.descricao = descricao;
        this.tipo = tipo;
        this.observacao = observacao;
    }

    @Deprecated
    public Equipamento() {
    }

    public int getId() {
        return id;
    }

    public String getSerial() {
        return serial;
    }

    public Campus getCampus() {
        return campus;
    }

    public String getDescricao() {
        return descricao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getObservacao() {
        return observacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void atualizar(EquipamentoRequest form) {
        this.serial = form.getSerial();
        this.descricao = form.getDescricao();
        this.observacao = form.getObservacao();
    }

    public void inativar(){
      this.ativo = false;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
