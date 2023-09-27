package com.desafio.SEASolutions.resource;

import com.desafio.SEASolutions.model.Cargo;
import com.desafio.SEASolutions.model.Setor;
import com.desafio.SEASolutions.repositories.CargoRepository;
import com.desafio.SEASolutions.repositories.SetorRepository;
import com.desafio.SEASolutions.service.CargoService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/cargos")
@Api("Api Cargos")
public class CargoResource {

    @Autowired
    private final CargoService service;

    @Autowired
    private final SetorRepository setorRepository;

    @Autowired
    private final CargoRepository cargoRepository;

    private Setor setor;

//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping
//    public Cargo save(@RequestBody @Valid Cargo cargo){
//        return service.save(cargo);
//    }

    @PostMapping
    public ResponseEntity<?> criarCargo(@RequestBody Cargo cargo) {
        // Verifica se o setor existe e está vinculado a este cargo
        Cargo cargoExistente = cargoRepository.findByNomeCargoAndSetor(cargo.getNomeCargo(), cargo.getSetor());
        if (cargoExistente != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Já existe um cargo com o mesmo nome neste setor.");
        }
        Cargo novoCargo = cargoRepository.save(cargo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCargo);
    }


    @GetMapping("{id}")
    public Cargo findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Cargo> findAllCargos(){
        return service.findAllCargos();
    }

}
