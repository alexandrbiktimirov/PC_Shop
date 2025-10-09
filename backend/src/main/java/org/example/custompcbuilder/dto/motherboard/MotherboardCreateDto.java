package org.example.custompcbuilder.dto.motherboard;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public record MotherboardCreateDto(
        @NotBlank String modelName,
        @NotBlank String brand,
        @NotNull @Positive BigDecimal price,
        @PositiveOrZero int quantity,
        @NotEmpty List<String> imageUrls,
        @NotBlank String socketType,
        @NotBlank String formFactor,
        @NotBlank String supportedMemoryType
) {}