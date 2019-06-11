package br.ufjf.dcc193.trab2.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufjf.dcc193.trab2.model.Area;
/**
 * AreaRepository
 */
public interface AreaRepository extends JpaRepository<Area, Long> {

  
}