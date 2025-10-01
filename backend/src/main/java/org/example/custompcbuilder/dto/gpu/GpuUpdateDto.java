package org.example.custompcbuilder.dto.gpu;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.List;

public record GpuUpdateDto(
        String modelName,
        String brand,
        BigDecimal price,
        @PositiveOrZero Integer quantity,
        List<String> imageUrls,
        @Positive Integer memorySizeGb,
        @Positive Integer tdpWatts,
        @Positive Integer lengthMm
) {
}
