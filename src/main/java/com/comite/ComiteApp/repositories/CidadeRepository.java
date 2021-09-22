package com.comite.ComiteApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.comite.ComiteApp.entities.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
