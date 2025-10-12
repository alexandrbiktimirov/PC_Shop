package org.example.custompcbuilder.dto.ram;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;
import java.util.List;

public record RamDto(
        Long id,
        String modelName,
        String brand,
        @JsonSerialize(using = ToStringSerializer.class)
        BigDecimal price,
        int quantity,
        List<String> imageUrls,
        String type,
        int totalCapacitySize,
        int speedMhz
) {}