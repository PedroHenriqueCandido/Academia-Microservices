package com.academia.planoservice.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_planos")
public class Plano {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	private String nome;
	private String descricao;
	private BigDecimal precoMensal;
	private Integer limiteUsuarios;
	private Boolean ativo;
	
	
	public Plano () {}

	
	

	public Plano(String nome, String descricao, BigDecimal precoMensal, Integer limiteUsuarios, Boolean ativo) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.precoMensal = precoMensal;
		this.limiteUsuarios = limiteUsuarios;
		this.ativo = ativo;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public BigDecimal getPrecoMensal() {
		return precoMensal;
	}


	public void setPrecoMensal(BigDecimal precoMensal) {
		this.precoMensal = precoMensal;
	}


	public Integer getLimiteUsuarios() {
		return limiteUsuarios;
	}


	public void setLimiteUsuarios(Integer limiteUsuarios) {
		this.limiteUsuarios = limiteUsuarios;
	}


	public Boolean getAtivo() {
		return ativo;
	}


	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
}
