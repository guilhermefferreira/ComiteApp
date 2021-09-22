package com.comite.ComiteApp.repositories;

import com.comite.ComiteApp.entities.Modalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalidadeRepository extends JpaRepository <Modalidade, Integer> {
}
