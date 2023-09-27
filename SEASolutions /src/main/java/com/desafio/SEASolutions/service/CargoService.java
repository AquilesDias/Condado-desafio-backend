package com.desafio.SEASolutions.service;

import com.desafio.SEASolutions.model.Cargo;
import com.desafio.SEASolutions.model.Setor;
import com.desafio.SEASolutions.repositories.CargoRepository;
import com.desafio.SEASolutions.repositories.SetorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
public class CargoService {

    @Autowired
    private CargoRepository repository;

    @Autowired
    private SetorRepository setorRepository;

    public Cargo save(Cargo cargo){

        // Verifica se o setor existe e está vinculado ao cargo
        Setor setor = setorRepository.findById(cargo.getSetor().getId()).orElseThrow(() ->
             new ResponseStatusException(HttpStatus.NOT_FOUND ,"Codigo setor invalido.")
        );

       boolean exists = setorRepository.existsByNomeSetorAndIdNot(cargo.getSetor().getNomeSetor()  ,setor.getId());
       if(!exists){
          throw new ResponseStatusException(HttpStatus.NOT_FOUND ,"Nome de Setor invalido.");
       }

        // Verifica se já existe um cargo com o mesmo nome neste setor
        Cargo cargoExist = repository.findByNomeCargoAndSetor(cargo.getNomeCargo(), cargo.getSetor());

        if(cargoExist != null){
            new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cargo existente.");
        }

        // Salvar o novo cargo
       Cargo novoCargo = repository.save(cargo);
       return novoCargo;
    }

    public Cargo findById(Long id){
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Cargo não encontrado com o id: "+id));
    }
    public List<Cargo> findAllCargos(){
        return repository.findAll();
    }
}

