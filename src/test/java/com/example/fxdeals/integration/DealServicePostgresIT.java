package com.example.fxdeals.integration;

import com.example.fxdeals.dto.DealDto;
import com.example.fxdeals.repository.DealRepository;
import com.example.fxdeals.service.DealService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@SpringBootTest
public class DealServicePostgresIT {

    @Container
    static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("fxdeals")
            .withUsername("fx")
            .withPassword("fxpass");

    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresContainer::getUsername);
        registry.add("spring.datasource.password", postgresContainer::getPassword);
    }


    @Autowired
    private DealService dealService;

    @Autowired
    private DealRepository repository;

    @Test
    void testImportDealPersists() {
        DealDto dto = new DealDto("D123", "USD", "EUR", 1000.0, "2025-11-17T12:00:00");
        dealService.importDeal(dto);

        assertTrue(repository.existsById("D123"));
    }

}
