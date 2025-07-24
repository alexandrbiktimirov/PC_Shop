package org.example.custompcbuilder.dto.cpu;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.List;

public record CpuUpdateDto(
        String modelName,
        String brand,
        @Positive BigDecimal price,
        @PositiveOrZero Integer quantity,
        List<String> imageUrls,
        String socketType,
        @Positive Integer coreCount,
        @Positive Integer threadCount,
        @Positive Integer tdpWatts
) {
}
