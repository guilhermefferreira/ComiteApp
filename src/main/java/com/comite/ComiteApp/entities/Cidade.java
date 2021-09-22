package com.comite.ComiteApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="cidade")
public class Cidade {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcidade")
	private Integer idcidade;
	
	
<<<<<<< HEAD
	@Column(name="nome", nullable = false)
	@Pattern(regexp = "[A-z]{5,50}", message = "O nome é invalido!")
=======
	@Column(name="nome", nullable = false, length = 50)	
	@Pattern(regexp = "[A-z]{5,50}")
>>>>>>> 1dcd43bacca5f19e0ed0c51b6cb3553a2d205df9
	private String nome;
		
	@Column(name="provincia", nullable = false)
	@Pattern(regexp = "[A-z]{5,50}", message = "O nome é invalido!")
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
