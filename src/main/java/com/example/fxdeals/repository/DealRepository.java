package com.example.fxdeals.repository;

import com.example.fxdeals.entity.DealEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepository extends JpaRepository<DealEntity, String> {
}
