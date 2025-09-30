package org.example.custompcbuilder.dto.gpu;

import java.math.BigDecimal;
import java.util.List;

public record GpuUpdateDto(
        String modelName,
        String brand,
        BigDecimal price,
        int quantity,
        List<String> imageUrls,
        int memorySizeGb,
        int tdpWatts,
        int lengthMm
) {
}
