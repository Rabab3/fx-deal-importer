package com.example.fxdeals.integration.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FxDealControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldSaveDealSuccessfully() throws Exception {

        String json = """
                {
                    "dealId": "D100",
                    "fromCurrency": "USD",
                    "toCurrency": "EUR",
                    "timestamp": "2024-01-01T12:00:00",
                    "amount": 1500
                }
                """;

        mockMvc.perform(
                post("/api/deals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpect(status().isCreated());
    }
}
