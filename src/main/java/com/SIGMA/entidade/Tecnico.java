package com.SIGMA.entidade;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Tecnico extends User{

    @ManyToOne
    @NotNull
    private Cargo cargo;

    public Tecnico(Cargo cargo) {
        super();
        this.cargo = cargo;
    }

    @Deprecated
    public Tecnico() {
       super();
    }

    public Cargo getCargo() {
        return cargo;
    }
}
