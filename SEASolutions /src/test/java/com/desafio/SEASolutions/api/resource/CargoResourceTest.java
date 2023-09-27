package com.desafio.SEASolutions.api.resource;

import com.desafio.SEASolutions.model.Cargo;
import com.desafio.SEASolutions.repositories.CargoRepository;
import com.desafio.SEASolutions.resource.CargoResource;
import com.desafio.SEASolutions.service.CargoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
@WebMvcTest(controllers = CargoResource.class)
public class CargoResourceTest {

    static String CARGO_API = "/api/cargos";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CargoService cargoService;
    @Autowired
    private CargoRepository cargoRepository;


    @Test
    @DisplayName("should return a cargo by id")
    public void shouldReturnCargoByIdTest() throws Exception {

        Long id = 1L;

        Cargo cargo = new Cargo();

        Mockito.when( cargoService.findById(Mockito.anyLong())).thenReturn(cargo);

        RequestBuilder request = MockMvcRequestBuilders.get(CARGO_API.concat("/"+id))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(id))
                .andExpect(MockMvcResultMatchers.jsonPath("nomeCargo").value(cargo.getNomeCargo()))
                .andExpect(MockMvcResultMatchers.jsonPath("setor").value(cargo.getSetor()))
                .andReturn();
    }



}
