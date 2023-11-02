package com.SIGMA.entidade.DTO.equipamento;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EquipamentoRequest {

    @NotBlank
    @Length(max = 30)
    private String serial;

    @NotNull
    private Integer campus;

    @NotBlank
    private String descricao;

    @NotNull
    private Integer tipo;

    @NotBlank
    private String observacao;

    public EquipamentoRequest(String serial, Integer campus, String descricao, Integer tipo, String observacao) {
        this.serial = serial;
        this.campus = campus;
        this.descricao = descricao;
        this.tipo = tipo;
        this.observacao = observacao;
    }

    @Deprecated
    public EquipamentoRequest(){
    }

    public String getSerial() {
        return serial;
    }

    public int getCampus() {
        return campus;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getTipo() {
        return tipo;
    }

    public String getObservacao() {
        return observacao;
    }
}
