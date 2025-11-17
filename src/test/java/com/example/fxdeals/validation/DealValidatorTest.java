package com.example.fxdeals.validation;

import com.example.fxdeals.dto.DealDto;
import com.example.fxdeals.exception.InvalidDealException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DealValidatorTest {

    private DealValidator validator;

    @Test
    void shouldValidateCorrectDeal() {
        DealDto dto = new DealDto("D-1", "USD", "EUR", 150, "2023-10-10T10:10:10");
        Assertions.assertDoesNotThrow(() -> DealValidator.validate(dto));
    }


    @Test
    void shouldThrowWhenAmountIsZero() {

        DealDto dto = new DealDto(
                "D-1",
                "USD",
                "EUR",
                0,
                "2023-10-10T10:10:10"
        );

        Assertions.assertThrows(InvalidDealException.class, () -> validator.validate(dto));
    }

    @Test
    void shouldThrowWhenAmountIsNegative() {

        DealDto dto = new DealDto(
                "D-1",
                "USD",
                "EUR",
                -20,
                "2023-10-10T10:10:10"
        );

        Assertions.assertThrows(InvalidDealException.class, () -> validator.validate(dto));
    }

    @Test
    void shouldThrowWhenCurrenciesAreSame() {

        DealDto dto = new DealDto(
                "D-1",
                "USD",
                "USD",
                200,
                "2023-10-10T10:10:10"
        );

        Assertions.assertThrows(InvalidDealException.class, () -> validator.validate(dto));
    }

    @Test
    void shouldThrowWhenDealIdIsMissing() {

        DealDto dto = new DealDto(
                null,
                "USD",
                "EUR",
                200,
                "2023-10-10T10:10:10"
        );

        Assertions.assertThrows(InvalidDealException.class, () -> validator.validate(dto));
    }

    @Test
    void shouldThrowWhenTimestampIsMissing() {

        DealDto dto = new DealDto(
                "D-1",
                "USD",
                "EUR",
                200,
                null   // timestamp null
        );

        Assertions.assertThrows(InvalidDealException.class, () -> validator.validate(dto));
    }
}
