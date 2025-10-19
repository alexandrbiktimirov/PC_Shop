package org.example.custompcbuilder.dto.storage;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public record StorageUpdateDto(
        String modelName,
        String brand,
        @Positive BigDecimal price,
        @PositiveOrZero Integer quantity,
        List<String> imageUrls,
        String type,
        String formFactor,
        @Positive Integer capacityGb
) {}