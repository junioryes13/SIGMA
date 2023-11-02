package com.SIGMA.entidade.DTO.user;

import com.SIGMA.entidade.User;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserResponse {


    @NotBlank
    private String nome;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    private String telefone;

    @NotBlank
    @Email
    private String email;


    public UserResponse(String nome, String cpf, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    @Deprecated
    public UserResponse(){}

    public UserResponse(User user) {
        this.nome = user.getNome();
        this.cpf = user.getCpf().substring(0,user.getCpf().length() - 4).replaceAll("[0-9]", "*").concat(user.getCpf().substring(user.getCpf().length() - 4));;
        this.telefone = user.getTelefone().substring(0,user.getTelefone().length() - 4).replaceAll("[0-9]", "*").concat(user.getTelefone().substring(user.getTelefone().length() - 4));
        this.email = user.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }


    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}
