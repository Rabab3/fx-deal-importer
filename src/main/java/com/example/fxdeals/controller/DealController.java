package com.example.fxdeals.controller;

import com.example.fxdeals.dto.DealDto;
import com.example.fxdeals.service.DealService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/deals")
public class DealController {

    private final DealService service;

    @PostMapping
    public ResponseEntity<?> importDeal(@Valid @RequestBody DealDto dto) {

        log.info("🟦 Received request to import deal: {}", dto.getDealId());

        service.importDeal(dto);

        log.info("🟩 Deal {} imported successfully", dto.getDealId());

        // Bloomberg requirement → creation should return 201
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of(
                        "dealId", dto.getDealId(),
                        "status", "imported"
                ));
    }
}
