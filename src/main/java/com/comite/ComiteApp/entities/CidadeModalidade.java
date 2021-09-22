package com.comite.ComiteApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cidademodalidade")
public class CidadeModalidade {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcidademodalidade")
	private Integer idCidadeModalidade;
	
	@Column(name="idcidade", nullable = false)	
	private Integer idCidade;
		
	@Column(name="idmodalidade", nullable = false)
	private Integer idModalidade;

	public Integer getIdCidadeModalidade() {
		return idCidadeModalidade;
	}

	public void setIdCidadeModalidade(Integer idCidadeModalidade) {
		this.idCidadeModalidade = idCidadeModalidade;
	}

	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	public Integer getIdModalidade() {
		return idModalidade;
	}

	public void setIdModalidade(Integer idModalidade) {
		this.idModalidade = idModalidade;
	}


	
}
