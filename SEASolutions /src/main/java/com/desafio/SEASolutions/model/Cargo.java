package com.desafio.SEASolutions.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Campo NOME CARGO é obrigatorio!")
    private String nomeCargo;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setor setor;

}
