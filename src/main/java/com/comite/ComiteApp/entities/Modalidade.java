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
	private String descricao;
	
	@Column(name = "data", nullable = false)
	@Pattern(regexp = "/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/", message = "Esta data é inválida")
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
