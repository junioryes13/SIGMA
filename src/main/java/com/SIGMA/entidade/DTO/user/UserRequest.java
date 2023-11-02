package com.SIGMA.entidade.DTO.user;

import com.SIGMA.entidade.User;
import com.SIGMA.security.JasyptAdvancedConfig;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class UserRequest {

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

    public UserRequest(String nome, String cpf, String senha, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
    }

    @Deprecated
    public UserRequest(){

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

    public User tomodel() {
        return new User(this.nome, this.cpf, this.senha, this.telefone, this.email);
    }
}
