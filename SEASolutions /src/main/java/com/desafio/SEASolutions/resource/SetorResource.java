package com.desafio.SEASolutions.resource;

import com.desafio.SEASolutions.model.Setor;
import com.desafio.SEASolutions.service.SetorService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/setores")
@Api("Api Setores")
public class SetorResource {

    @Autowired
    private final SetorService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Setor save(@RequestBody @Valid Setor setor){

        return service.save(setor);
    }

    @GetMapping
    public List<Setor> findAllSetor(){
        return service.findAllSetor();
    }
}
