package org.example.custompcbuilder.mapper;

import org.example.custompcbuilder.dto.psu.PsuCreateDto;
import org.example.custompcbuilder.dto.psu.PsuDto;
import org.example.custompcbuilder.entity.Psu;

public class PsuMapper {

    public static PsuDto toDto(Psu psu) {
        if (psu == null) return null;

        return new PsuDto(
                psu.getId(),
                psu.getModelName(),
                psu.getBrand(),
                psu.getPrice(),
                psu.getQuantity(),
                psu.getImageUrls(),
                psu.getWattage(),
                psu.getFormFactor()
        );
    }

    public static Psu toEntity(PsuCreateDto dto) {
        if (dto == null) return null;

        Psu psu = new Psu();
        psu.setModelName(dto.modelName());
        psu.setBrand(dto.brand());
        psu.setPrice(dto.price());
        psu.setQuantity(dto.quantity());
        psu.setImageUrls(dto.imageUrls());
        psu.setWattage(dto.wattage());
        psu.setFormFactor(dto.formFactor());

        return psu;
    }
}