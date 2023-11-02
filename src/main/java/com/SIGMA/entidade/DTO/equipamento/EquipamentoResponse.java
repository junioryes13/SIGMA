package com.SIGMA.entidade.DTO.equipamento;

import com.SIGMA.entidade.Equipamento;

public class EquipamentoResponse {

    private String campus;

    private String descricao;

    private String tipo;

    private String observacao;

    public EquipamentoResponse(Equipamento equipamento){
        this.campus = equipamento.getCampus().getNome();
        this.descricao = equipamento.getDescricao();
        this.tipo = equipamento.getTipo().getNome();
        this.observacao = equipamento.getObservacao();
    }

    public String getCampus() {
        return campus;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public String getObservacao() {
        return observacao;
    }
}
