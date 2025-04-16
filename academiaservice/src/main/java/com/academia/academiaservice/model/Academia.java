package com.academia.academiaservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_academia")
public class Academia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cnpj;
    private String telefone;
    private String email;
    private String responsavel;
    private String endereco;
    private String cidade;
    private String estado;
    private String cep;
    private Boolean ativo = true;

    public Academia() {}

	public Academia(Long id, String nome, String cnpj, String telefone, String email, String responsavel,
			String endereco, String cidade, String estado, String cep, Boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.email = email;
		this.responsavel = responsavel;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
    
	@Override
    public String toString() {
        return "Academia{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
