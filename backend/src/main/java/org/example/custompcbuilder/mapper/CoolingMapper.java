package org.example.custompcbuilder.mapper;

import org.example.custompcbuilder.dto.cooling.CoolingCreateDto;
import org.example.custompcbuilder.dto.cooling.CoolingDto;
import org.example.custompcbuilder.entity.Cooling;

public class CoolingMapper {

    public static CoolingDto toDto(Cooling c) {
        if (c == null) return null;
        return new CoolingDto(
                c.getId(),
                c.getModelName(),
                c.getBrand(),
                c.getPrice(),
                c.getQuantity(),
                c.getImageUrls(),
                c.getType(),
                c.getSupportedSockets(),
                c.getTdpWattsRating()
        );
    }

    public static Cooling toEntity(CoolingCreateDto dto) {
        if (dto == null) return null;
        var c = new Cooling();
        c.setModelName(dto.modelName());
        c.setBrand(dto.brand());
        c.setPrice(dto.price());
        c.setQuantity(dto.quantity());
        c.setImageUrls(dto.imageUrls());
        c.setType(dto.type());
        c.setSupportedSockets(dto.supportedSockets());
        c.setTdpWattsRating(dto.tdpWattsRating());
        return c;
    }
}