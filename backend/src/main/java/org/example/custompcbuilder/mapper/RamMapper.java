package org.example.custompcbuilder.mapper;

import org.example.custompcbuilder.dto.ram.RamCreateDto;
import org.example.custompcbuilder.dto.ram.RamDto;
import org.example.custompcbuilder.entity.Ram;

public class RamMapper {

    public static RamDto toDto(Ram ram) {
        return new RamDto(
                ram.getId(),
                ram.getModelName(),
                ram.getBrand(),
                ram.getPrice(),
                ram.getQuantity(),
                ram.getImageUrls(),
                ram.getType(),
                ram.getTotalCapacitySize(),
                ram.getSpeedMhz()
        );
    }

    public static Ram toEntity(RamCreateDto dto) {
        var ram = new Ram();
        ram.setModelName(dto.modelName());
        ram.setBrand(dto.brand());
        ram.setPrice(dto.price());
        ram.setQuantity(dto.quantity());
        ram.setImageUrls(dto.imageUrls());
        ram.setType(dto.type());
        ram.setTotalCapacitySize(dto.totalCapacitySize());
        ram.setSpeedMhz(dto.speedMhz());
        return ram;
    }
}