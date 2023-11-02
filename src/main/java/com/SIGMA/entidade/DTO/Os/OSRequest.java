package com.SIGMA.entidade.DTO.Os;

import com.SIGMA.entidade.Equipamento;
import com.SIGMA.entidade.Prioridade;
import com.SIGMA.entidade.Tecnico;
import com.SIGMA.entidade.User;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

public class OSRequest {

    @ManyToOne
    @javax.validation.constraints.NotNull
    private User requerente;

    @ManyToOne
    @javax.validation.constraints.NotNull
    private Equipamento equipamento;

    @ManyToOne
    private Tecnico tecnico;

    @NotBlank
    private String defeitos;

    private String defeitosEncontrados;

    private String prioridade;


    public User getRequerente() {
        return requerente;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public String getDefeitos() {
        return defeitos;
    }

    public String getDefeitosEncontrados() {
        return defeitosEncontrados;
    }

    public String getPrioridade() {
        return prioridade;
    }
}
