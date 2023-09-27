package com.desafio.SEASolutions.repositories;


import com.desafio.SEASolutions.model.Cargo;
import com.desafio.SEASolutions.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

    Cargo findByNomeCargoAndSetor(String nomeCargo, Setor setor);
}
