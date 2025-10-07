package org.example.custompcbuilder.mapper;

import org.example.custompcbuilder.dto.cases.CaseCreateDto;
import org.example.custompcbuilder.dto.cases.CaseDto;
import org.example.custompcbuilder.entity.Case;

public class CaseMapper {

    public static CaseDto toDto(Case c) {
        if (c == null) return null;
        return new CaseDto(
                c.getId(),
                c.getModelName(),
                c.getBrand(),
                c.getPrice(),
                c.getQuantity(),
                c.getImageUrls(),
                c.getFormFactorSupport(),
                c.getMaxGpuLengthMm()
        );
    }

    public static Case toEntity(CaseCreateDto dto) {
        if (dto == null) return null;
        var c = new Case();
        c.setModelName(dto.modelName());
        c.setBrand(dto.brand());
        c.setPrice(dto.price());
        c.setQuantity(dto.quantity());
        c.setImageUrls(dto.imageUrls());
        c.setFormFactorSupport(dto.formFactorSupport());
        c.setMaxGpuLengthMm(dto.maxGpuLengthMm());
        return c;
    }
}