package com.desafio.SEASolutions.service;


import com.desafio.SEASolutions.model.Trabalhador;
import com.desafio.SEASolutions.repositories.TrabalhadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TrabalhadorService {

    @Autowired
    private TrabalhadorRepository repository;

    public Trabalhador save(Trabalhador trabalhador){

        if( repository.existsByCpf(trabalhador.getCpf())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Número CPF já existente.");
        }

        return repository.save(trabalhador);
    }

    public List<Trabalhador> findAllTrabalhadores(){
        return repository.findAll();
    }
}
