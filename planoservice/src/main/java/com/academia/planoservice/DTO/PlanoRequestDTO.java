package com.academia.planoservice.DTO;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PlanoRequestDTO {

	@NotBlank
	private String nome;
	
	private String descricao;
	
	@NotNull
	@DecimalMin("0.0")
	private BigDecimal precoMensal;
	
	@NotNull
	@Min(1)
	private Integer limiteUsuarios;
	
	public PlanoRequestDTO() {}

	
	public PlanoRequestDTO(@NotBlank String nome, String descricao, @NotNull @DecimalMin("0.0") BigDecimal precoMensal,
			@NotNull @Min(1) Integer limiteUsuarios) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.precoMensal = precoMensal;
		this.limiteUsuarios = limiteUsuarios;
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
	
	
}
