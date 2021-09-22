package com.comite.ComiteApp.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Atleta")
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idatleta")
    private int idatleta;

    @Column(name = "nome", nullable = false, length = 50)
    @Pattern(regexp = "[A-z]{5,50}", message = "O nome é invalido!")
    private String nome;

    @Column(name = "inscricao", nullable = false, length = 50)
    private String inscricao;

    public int getIdatleta() {
        return idatleta;
    }

    public void setIdatleta(int idatleta) {
        this.idatleta = idatleta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }
}
