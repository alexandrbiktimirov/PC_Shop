package org.example.custompcbuilder.dto.ram;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public record RamUpdateDto(
        String modelName,
        String brand,
        @Positive BigDecimal price,
        @PositiveOrZero Integer quantity,
        List<String> imageUrls,
        String type,
        @Positive Integer totalCapacitySize,
        @Positive Integer speedMhz
) {}