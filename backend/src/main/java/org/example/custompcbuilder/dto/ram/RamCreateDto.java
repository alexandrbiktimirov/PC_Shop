package org.example.custompcbuilder.dto.ram;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public record RamCreateDto(
        @NotBlank String modelName,
        @NotBlank String brand,
        @NotNull @Positive BigDecimal price,
        @PositiveOrZero int quantity,
        @NotEmpty List<String> imageUrls,
        @NotBlank String type,
        @Positive int totalCapacitySize,
        @Positive int speedMhz
) {}