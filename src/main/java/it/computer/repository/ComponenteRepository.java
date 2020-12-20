package it.computer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.computer.model.Componente;

public interface ComponenteRepository extends JpaRepository<Componente, Integer>{

}
