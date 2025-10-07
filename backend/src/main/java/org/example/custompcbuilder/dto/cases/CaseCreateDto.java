package org.example.custompcbuilder.dto.cases;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public record CaseCreateDto(
        @NotBlank String modelName,
        @NotBlank String brand,
        @NotNull @Positive BigDecimal price,
        @PositiveOrZero int quantity,
        @NotEmpty List<String> imageUrls,
        @NotBlank String formFactorSupport,
        @Positive int maxGpuLengthMm
) {}