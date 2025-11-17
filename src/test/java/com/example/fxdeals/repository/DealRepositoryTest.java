package com.example.fxdeals.repository;

import com.example.fxdeals.entity.DealEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@DataJpaTest
class DealRepositoryTest {

    @Autowired
    private DealRepository repository;

    @Test
    void shouldSaveDeal() {
        DealEntity entity = new DealEntity();
        entity.setDealId("D-1");
        entity.setFromCurrency("USD");
        entity.setToCurrency("EUR");

        // amount est un double → pas une string
        entity.setAmount(150);

        // timestamp est un LocalDateTime → pas une string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        entity.setTimestamp(LocalDateTime.parse("2023-10-10 10:10:10", formatter));

        repository.save(entity);

        Assertions.assertTrue(repository.existsById("D-1"));
    }


}
