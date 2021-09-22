package com.comite.ComiteApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comite.ComiteApp.entities.AtletaModalidade;

@Repository
public interface AtletaModalidadeRepository extends JpaRepository<AtletaModalidade, Integer> {

}
