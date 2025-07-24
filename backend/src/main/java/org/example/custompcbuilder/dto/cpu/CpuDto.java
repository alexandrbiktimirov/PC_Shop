package org.example.custompcbuilder.dto.cpu;

import java.math.BigDecimal;
import java.util.List;

public record CpuDto (
    Long id,
    String modelName,
    String brand,
    BigDecimal price,
    int quantity,
    List<String> imageUrls,
    String socketType,
    int coreCount,
    int threadCount,
    int tdpWatts
){}
