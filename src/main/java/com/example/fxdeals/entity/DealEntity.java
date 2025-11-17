package com.example.fxdeals.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "fx_deals")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class DealEntity {

    @Id
    private String dealId;

    private String fromCurrency;
    private String toCurrency;
    private LocalDateTime timestamp;
    private double amount;
}
