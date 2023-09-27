package com.desafio.SEASolutions.resource;


import com.desafio.SEASolutions.model.Trabalhador;
import com.desafio.SEASolutions.service.TrabalhadorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/trabalhadores")
@Api("Api Trabalhadores")
public class TrabalhadorResource {

    private final TrabalhadorService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Trabalhador save(@RequestBody @Valid Trabalhador trabalhador){
        return service.save(trabalhador);
    }

    @GetMapping
    @ApiOperation("Obter todos trabalhadores")
    public List<Trabalhador> findAllTrabalhadores(){
        return service.findAllTrabalhadores();
    }
}
