package com.desafio.SEASolutions.repositories;

import com.desafio.SEASolutions.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetorRepository extends JpaRepository<Setor, Long> {

     // Verifica a existencia do nome do Setor.
     boolean existsByNomeSetor(String nomeSetor);

     boolean existsByNomeSetorAndIdNot(String nomeSetor, Long id);
}
