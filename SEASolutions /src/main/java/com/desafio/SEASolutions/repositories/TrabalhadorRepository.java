package com.desafio.SEASolutions.repositories;

import com.desafio.SEASolutions.model.Trabalhador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabalhadorRepository extends JpaRepository<Trabalhador, Long> {

    boolean existsByCpf(String cpf);
}
