package com.SIGMA.entidade;

import com.SIGMA.entidade.DTO.user.UserRequest;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity(name = "usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String nome;

    @NotBlank
    @CPF
    private String cpf;

    @NotNull
    private String senha;

    @NotBlank
    private String telefone;

    @NotBlank
    @Email
    private String email;

    private LocalDateTime dataCadastro;

    private LocalDateTime dataInativo;

    private boolean ativo;


    public User(String nome, String cpf, String senha, String telefone, String email) {

        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = LocalDateTime.now();
        this.ativo = true;
    }

    @Deprecated
    public User(){
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void inativar() {
        this.ativo = false;
    }

    public void atualizar(UserRequest request) {
        this.nome = request.getNome();
        this.email = request.getEmail();
        this.telefone = request.getTelefone();
    }
}
