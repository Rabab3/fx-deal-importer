package com.example.fxdeals.service.impl;

import com.example.fxdeals.dto.DealDto;
import com.example.fxdeals.entity.DealEntity;
import com.example.fxdeals.exception.DealAlreadyExistsException;
import com.example.fxdeals.exception.InvalidDealException;
import com.example.fxdeals.repository.DealRepository;
import com.example.fxdeals.service.DealService;
import com.example.fxdeals.validation.DealValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

@Slf4j
@Service
@RequiredArgsConstructor
public class DealServiceImpl implements DealService {

    private final DealRepository repository;

    @Override
    public void importDeal(DealDto dto) {

        log.debug("🔎 Checking business rules for deal {}", dto.getDealId());

// Validation métier : from != to
        if (dto.getFromCurrency() != null && dto.getFromCurrency().equals(dto.getToCurrency())) {
            log.warn("⚠️ From and To currencies are the same for deal {}", dto.getDealId());
            throw new InvalidDealException("From and To currencies must differ");
        }

// Duplicate check
        log.debug("🔎 Checking if deal {} already exists", dto.getDealId());
        if (repository.existsById(dto.getDealId())) {
            log.warn("⚠️ Duplicate detected: {}", dto.getDealId());
            throw new DealAlreadyExistsException(dto.getDealId());
        }

// Timestamp parsing (ISO-8601)
        LocalDateTime timestamp;
        try {
            timestamp = LocalDateTime.parse(dto.getTimestamp());
        } catch (DateTimeParseException e) {
            log.error("❌ Invalid timestamp format: {}", dto.getTimestamp());
            throw new InvalidDealException("Invalid timestamp format. Expected ISO-8601.");
        }


        DealEntity entity = DealEntity.builder()
                .dealId(dto.getDealId())
                .fromCurrency(dto.getFromCurrency())
                .toCurrency(dto.getToCurrency())
                .amount(dto.getAmount())
                .timestamp(timestamp)
                .build();

        log.info("💾 Saving deal {}", dto.getDealId());
        repository.save(entity);
    }
}
