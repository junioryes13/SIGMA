package com.SIGMA.entidade;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String nome;

	public Cargo( String nome) {
		this.nome = nome;
	}

	@Deprecated
	public Cargo() {
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
