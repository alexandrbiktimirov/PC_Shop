package org.example.custompcbuilder.dto.cooling;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public record CoolingCreateDto(
        @NotBlank String modelName,
        @NotBlank String brand,
        @NotNull @Positive BigDecimal price,
        @PositiveOrZero int quantity,
        @NotEmpty List<String> imageUrls,
        @NotBlank String type,
        @NotBlank String supportedSockets,
        @Positive int tdpWattsRating
) {}