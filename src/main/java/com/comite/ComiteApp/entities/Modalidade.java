package com.comite.ComiteApp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class Modalidade {
	
	@Id
    @Column(name="idmodalidade")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idModalidade;	
	
	@Column(name = "descricao", nullable = false, length = 50)
	@Pattern(regexp = "[A-z]{5,50}")
	private String descricao;
	
	@Column(name = "data", nullable = false)
	private Date data;

	public int getIdModalidade() {
		return idModalidade;
	}

	public void setIdModalidade(int idModalidade) {
		this.idModalidade = idModalidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
   
	
}
