package org.example.custompcbuilder.dto.gpu;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.List;

public record GpuCreateDto(
        @NotBlank String modelName,
        @NotBlank String brand,
        @NotNull @Positive BigDecimal price,
        @PositiveOrZero int quantity,
        @NotEmpty List<String> imageUrls,
        @Positive int memorySizeGb,
        @Positive int tdpWatts,
        @Positive int lengthMm
) {}