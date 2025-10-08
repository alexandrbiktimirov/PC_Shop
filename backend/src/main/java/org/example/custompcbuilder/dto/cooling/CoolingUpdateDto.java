package org.example.custompcbuilder.dto.cooling;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.List;

public record CoolingUpdateDto(
        String modelName,
        String brand,
        BigDecimal price,
        @PositiveOrZero Integer quantity,
        List<String> imageUrls,
        String type,
        String supportedSockets,
        @Positive Integer tdpWattsRating
) {}