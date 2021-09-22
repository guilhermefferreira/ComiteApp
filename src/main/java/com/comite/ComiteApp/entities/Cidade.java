package com.comite.ComiteApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cidade")
public class Cidade {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcidade")
	private Integer idcidade;
	
	
	@Column(name="nome", nullable = false)	
	private String nome;
		
	@Column(name="provincia", nullable = false)
	private String provincia;

	public Integer getIdcidade() {
		return idcidade;
	}

	public void setIdcidade(Integer idcidade) {
		this.idcidade = idcidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	

	


	
}
