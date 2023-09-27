package com.desafio.SEASolutions.service;

import com.desafio.SEASolutions.model.Setor;
import com.desafio.SEASolutions.repositories.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SetorService {

    @Autowired
    private SetorRepository repository;

    public Setor save(Setor setor){

        if(repository.existsByNomeSetor(setor.getNomeSetor())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Setor já existente.");
        }

        return repository.save(setor);
    }

    public List<Setor> findAllSetor(){
        return repository.findAll();
    }
}
