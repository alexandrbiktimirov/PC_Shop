package org.example.custompcbuilder.mapper;

import org.example.custompcbuilder.dto.storage.StorageCreateDto;
import org.example.custompcbuilder.dto.storage.StorageDto;
import org.example.custompcbuilder.entity.Storage;

public class StorageMapper {
    public static StorageDto toDto(Storage s) {
        return new StorageDto(
                s.getId(),
                s.getModelName(),
                s.getBrand(),
                s.getPrice(),
                s.getQuantity(),
                s.getImageUrls(),
                s.getType(),
                s.getFormFactor(),
                s.getCapacityGb()
        );
    }

    public static Storage toEntity(StorageCreateDto dto) {
        var s = new Storage();
        s.setModelName(dto.modelName());
        s.setBrand(dto.brand());
        s.setPrice(dto.price());
        s.setQuantity(dto.quantity());
        s.setImageUrls(dto.imageUrls());
        s.setType(dto.type());
        s.setFormFactor(dto.formFactor());
        s.setCapacityGb(dto.capacityGb());
        return s;
    }
}