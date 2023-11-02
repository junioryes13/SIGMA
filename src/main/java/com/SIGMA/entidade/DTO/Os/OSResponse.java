package com.SIGMA.entidade.DTO.Os;

import com.SIGMA.entidade.DTO.equipamento.EquipamentoResponse;
import com.SIGMA.entidade.OrdemDeServico;

public class OSResponse {
    private String requerente;
    private EquipamentoResponse equipamento;
    private String tecnico;
    private String defeitos;
    private String defeitosEncontrados;
    private String dataAbertura;
    private String dataEncerramento;
    private String status;
    private String solucao;

    public OSResponse(String requerente, EquipamentoResponse equipamento, String tecnico, String defeitos, String defeitosEncontrados, String dataAbertura, String dataEncerramento, String status, String solucao) {
        this.requerente = requerente;
        this.equipamento = equipamento;
        this.tecnico = tecnico;
        this.defeitos = defeitos;
        this.defeitosEncontrados = defeitosEncontrados;
        this.dataAbertura = dataAbertura;
        this.dataEncerramento = dataEncerramento;
        this.status = status;
        this.solucao = solucao;
    }

    public OSResponse(OrdemDeServico ordemDeServico) {
        this.requerente = ordemDeServico.getRequerente().getNome();
        this.equipamento = new EquipamentoResponse(ordemDeServico.getEquipamento());
        this.tecnico = ordemDeServico.getTecnico().getNome();
        this.defeitos = ordemDeServico.getDefeitos();
        this.defeitosEncontrados = ordemDeServico.getDefeitosEncontrados();
        this.dataAbertura = ordemDeServico.getDataAbertura();
        this.dataEncerramento = ordemDeServico.getDataFechamento();
        this.solucao = ordemDeServico.getSolucao();
        this.solucao = ordemDeServico.getSolucao();

    }

    @Deprecated
    public OSResponse() {
    }

    public String getRequerente() {
        return requerente;
    }

    public EquipamentoResponse getEquipamento() {
        return equipamento;
    }

    public String getTecnico() {
        return tecnico;
    }

    public String getDefeitos() {
        return defeitos;
    }

    public String getDefeitosEncontrados() {
        return defeitosEncontrados;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public String getDataEncerramento() {
        return dataEncerramento;
    }

    public String getStatus() {
        return status;
    }

    public String getSolucao() {
        return solucao;
    }
}
