package com.example.fxdeals.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DealDto {

    @NotBlank(message = "Deal ID is required")
    private String dealId;

    @Pattern(regexp = "^[A-Z]{3}$", message = "From currency must be 3 uppercase letters")
    private String fromCurrency;

    @Pattern(regexp = "^[A-Z]{3}$", message = "To currency must be 3 uppercase letters")
    private String toCurrency;

    @Positive(message = "Amount must be positive")
    private double amount;

    @NotBlank(message = "Timestamp is required")
    private String timestamp;
}
