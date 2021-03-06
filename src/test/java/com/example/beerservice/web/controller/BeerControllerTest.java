package com.example.beerservice.web.controller;

import com.example.beerservice.web.model.BeerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Test
    void getBeeByID() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto=BeerDto.builder().build();
        String beerdtojson=objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(post("/api/v1/beer").content(beerdtojson).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    @Test
    void testUpdateBeer() throws Exception {
        BeerDto beerDto=BeerDto.builder().build();
        String beerdtojson=objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString()).content(beerdtojson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
