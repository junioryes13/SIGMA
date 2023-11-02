package com.SIGMA.entidade;

import com.SIGMA.entidade.DTO.Os.OSRequest;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
public class OrdemDeServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    private String solucao;

    @NotNull
    private String dataAbertura;

    @PastOrPresent
    private String dataFechamento;

    @NotBlank
    private Status status;

    @javax.validation.constraints.NotNull
    private Prioridade prioridade;

    boolean ativo = true;


    @Deprecated
    public OrdemDeServico() {
    }

    public OrdemDeServico(User requerente, String nomeRequerente, String emailRequerente, String telefoneRequerente, Equipamento equipamento, String defeitos, String dataAbertura, Prioridade prioridade) {
        this.requerente = requerente;
        this.equipamento = equipamento;
        this.defeitos = defeitos;
        this.dataAbertura = dataAbertura;
        this.prioridade = prioridade;
    }

    public OrdemDeServico(OSRequest os) {
        this.requerente = os.getRequerente();
        this.equipamento = os.getEquipamento();
        this.defeitos = os.getDefeitos();
        this.dataAbertura = LocalDateTime.now().toString();
        this.prioridade = Prioridade.valueOf(os.getPrioridade());
    }

    public int getId() {
        return id;
    }

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

    public String getSolucao() {
        return solucao;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }

    public Status getStatus() {
        return status;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void inativar() {
        this.ativo = false;

    }
}
