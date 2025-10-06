package org.example.custompcbuilder.dto.psu;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.List;

public record PsuUpdateDto(
        String modelName,
        String brand,
        BigDecimal price,
        @PositiveOrZero Integer quantity,
        List<String> imageUrls,
        @Positive Integer wattage,
        String formFactor
) {}