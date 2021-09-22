package com.comite.ComiteApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "atletamodalidade")
public class AtletaModalidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAtletaModalidade;
	
	@Column(name = "idatleta", nullable = false)
	private int idAtleta;
	
	@Column(name = "idmodalidade", nullable = false, precision=11, scale=0)
	private int idModalidade;

	public int getIdAtletaModalidade() {
		return idAtletaModalidade;
	}

	public void setIdAtletaModalidade(int idAtletaModalidade) {
		this.idAtletaModalidade = idAtletaModalidade;
	}

	public int getIdAtleta() {
		return idAtleta;
	}

	public void setIdAtleta(int idAtleta) {
		this.idAtleta = idAtleta;
	}

	public int getIdModalidade() {
		return idModalidade;
	}

	public void setIdModalidade(int idModalidade) {
		this.idModalidade = idModalidade;
	}
	
	
	
}
