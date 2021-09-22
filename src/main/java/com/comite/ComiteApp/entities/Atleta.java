package com.comite.ComiteApp.entities;

import javax.persistence.*;

@Entity
@Table(name = "Atleta")
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idatleta")
    private int idatleta;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "inscricao", nullable = false, length = 50)
    private String inscricao;

}
