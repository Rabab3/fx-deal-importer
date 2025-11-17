package com.example.fxdeals.controller;

import com.example.fxdeals.dto.DealDto;
import com.example.fxdeals.service.DealService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DealController.class)
class DealControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DealService service;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldReturn200WhenDealIsSaved() throws Exception {

        DealDto dto = new DealDto(
                "D-1",
                "USD",
                "EUR",
                200,  // double
                "2023-10-10T10:10:10"
        );

        // important : matcher ANY object because MockMvc creates a NEW DealDto instance
        doNothing().when(service).importDeal(ArgumentMatchers.any(DealDto.class));

        mockMvc.perform(post("/api/deals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isCreated());

    }

    @Test
    void shouldReturn400WhenInvalidDeal() throws Exception {

        // montant négatif => validation doit échouer
        DealDto dto = new DealDto(
                "D-1",
                "USD",
                "EUR",
                -50,
                "2023-10-10T10:10:10"
        );

        mockMvc.perform(post("/api/deals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }
}
