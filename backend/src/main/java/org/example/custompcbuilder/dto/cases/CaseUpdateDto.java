package org.example.custompcbuilder.dto.cases;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.List;

public record CaseUpdateDto(
        String modelName,
        String brand,
        BigDecimal price,
        @PositiveOrZero Integer quantity,
        List<String> imageUrls,
        String formFactorSupport,
        @Positive Integer maxGpuLengthMm
) {}