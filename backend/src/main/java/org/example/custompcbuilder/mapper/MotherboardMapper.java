package org.example.custompcbuilder.mapper;

import org.example.custompcbuilder.dto.motherboard.MotherboardCreateDto;
import org.example.custompcbuilder.dto.motherboard.MotherboardDto;
import org.example.custompcbuilder.entity.Motherboard;

public class MotherboardMapper {

    public static MotherboardDto toDto(Motherboard mb) {
        if (mb == null) return null;
        return new MotherboardDto(
                mb.getId(),
                mb.getModelName(),
                mb.getBrand(),
                mb.getPrice(),
                mb.getQuantity(),
                mb.getImageUrls(),
                mb.getSocketType(),
                mb.getFormFactor(),
                mb.getSupportedMemoryType()
        );
    }

    public static Motherboard toEntity(MotherboardCreateDto dto) {
        if (dto == null) return null;
        var mb = new Motherboard();
        mb.setModelName(dto.modelName());
        mb.setBrand(dto.brand());
        mb.setPrice(dto.price());
        mb.setQuantity(dto.quantity());
        mb.setImageUrls(dto.imageUrls());
        mb.setSocketType(dto.socketType());
        mb.setFormFactor(dto.formFactor());
        mb.setSupportedMemoryType(dto.supportedMemoryType());
        return mb;
    }
}