package org.example.custompcbuilder.dto.cpu;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.List;

public record CpuCreateDto(
        @NotBlank String modelName,
        @NotBlank String brand,
        @NotNull @Positive BigDecimal price,
        @PositiveOrZero int quantity,
        @NotEmpty List<String> imageUrls,
        @NotBlank String socketType,
        @Positive int coreCount,
        @Positive int threadCount,
        @Positive int tdpWatts
) {
}
