package com.example.fxdeals.validation;

import com.example.fxdeals.dto.DealDto;
import com.example.fxdeals.exception.InvalidDealException;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class DealValidator {

    public static void validate(DealDto dto) {

        // Deal ID required
        if (dto.getDealId() == null || dto.getDealId().isEmpty()) {
            throw new InvalidDealException("Deal ID is required");
        }

        // From currency must be 3 chars
        if (dto.getFromCurrency() == null || dto.getFromCurrency().length() != 3) {
            throw new InvalidDealException("Invalid from currency");
        }

        // To currency must be 3 chars
        if (dto.getToCurrency() == null || dto.getToCurrency().length() != 3) {
            throw new InvalidDealException("Invalid to currency");
        }

        // Currencies must differ
        if (dto.getFromCurrency().equals(dto.getToCurrency())) {
            throw new InvalidDealException("From and To currencies must differ");
        }

        // Amount must be > 0
        if (dto.getAmount() <= 0) {
            throw new InvalidDealException("Amount must be positive");
        }

        // Timestamp required
        if (dto.getTimestamp() == null || dto.getTimestamp().isEmpty()) {
            throw new InvalidDealException("Timestamp is required");
        }

        // Timestamp must be ISO-8601
        try {
            LocalDateTime.parse(dto.getTimestamp());
        } catch (DateTimeParseException e) {
            throw new InvalidDealException("Invalid timestamp format. Expected ISO-8601.");
        }
    }
}
