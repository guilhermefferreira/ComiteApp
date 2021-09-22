package com.comite.ComiteApp.repositories;

import com.comite.ComiteApp.entities.CidadeModalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeModalidadeRepository extends JpaRepository<CidadeModalidade, Integer> {

}
