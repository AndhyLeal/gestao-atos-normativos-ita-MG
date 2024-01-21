package com.acervo_digital.gestaoatosnormativositaMG.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acervo_digital.gestaoatosnormativositaMG.entidades.Decreto;

@Repository
public interface DecretoRepository extends JpaRepository<Decreto, Long> {

	 List<Decreto> findByAno(Integer ano);
	    List<Decreto> findByNumero(String numero);
	    List<Decreto> findByEmentaContaining(String ementa);
}
