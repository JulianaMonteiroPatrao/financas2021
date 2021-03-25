package br.fatec.financas2021.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fatec.financas2021.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
	
}
