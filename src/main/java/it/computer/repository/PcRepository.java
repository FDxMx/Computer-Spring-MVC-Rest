package it.computer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.computer.model.Pc;

public interface PcRepository extends JpaRepository<Pc, Integer>{

}
