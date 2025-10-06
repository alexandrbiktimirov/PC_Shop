package org.example.custompcbuilder.dto.psu;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public record PsuCreateDto(
        @NotBlank String modelName,
        @NotBlank String brand,
        @NotNull @Positive BigDecimal price,
        @PositiveOrZero int quantity,
        @NotEmpty List<String> imageUrls,
        @Positive int wattage,
        @NotBlank String formFactor
) {}