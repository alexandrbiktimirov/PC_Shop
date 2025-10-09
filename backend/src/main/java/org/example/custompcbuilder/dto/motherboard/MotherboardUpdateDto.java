package org.example.custompcbuilder.dto.motherboard;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.List;

public record MotherboardUpdateDto(
        String modelName,
        String brand,
        BigDecimal price,
        @PositiveOrZero Integer quantity,
        List<String> imageUrls,
        String socketType,
        String formFactor,
        String supportedMemoryType
) {}