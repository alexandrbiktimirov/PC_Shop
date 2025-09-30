package org.example.custompcbuilder.mapper;

import org.example.custompcbuilder.dto.gpu.GpuCreateDto;
import org.example.custompcbuilder.dto.gpu.GpuDto;
import org.example.custompcbuilder.entity.Gpu;

public class GpuMapper {
    public static GpuDto toDto(Gpu gpu) {
        return new GpuDto(
                gpu.getId(),
                gpu.getModelName(),
                gpu.getBrand(),
                gpu.getPrice(),
                gpu.getQuantity(),
                gpu.getImageUrls(),
                gpu.getMemorySizeGb(),
                gpu.getTdpWatts(),
                gpu.getLengthMm()
        );
    }

    public static Gpu toEntity(GpuCreateDto gpuCreateDto) {
        var gpu = new Gpu();

        gpu.setBrand(gpuCreateDto.brand());
        gpu.setModelName(gpuCreateDto.modelName());
        gpu.setPrice(gpuCreateDto.price());
        gpu.setQuantity(gpuCreateDto.quantity());
        gpu.setImageUrls(gpuCreateDto.imageUrls());
        gpu.setMemorySizeGb(gpuCreateDto.memorySizeGb());
        gpu.setTdpWatts(gpuCreateDto.tdpWatts());
        gpu.setLengthMm(gpuCreateDto.lengthMm());

        return gpu;
    }
}
