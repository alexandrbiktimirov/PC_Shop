package org.example.custompcbuilder.mapper;

import org.example.custompcbuilder.dto.cpu.CpuCreateDto;
import org.example.custompcbuilder.dto.cpu.CpuDto;
import org.example.custompcbuilder.entity.Cpu;

public class CpuMapper {
    public static CpuDto toDto(Cpu cpu) {
        return new CpuDto(
                cpu.getId(),
                cpu.getModelName(),
                cpu.getBrand(),
                cpu.getPrice(),
                cpu.getQuantity(),
                cpu.getImageUrls(),
                cpu.getSocketType(),
                cpu.getCoreCount(),
                cpu.getThreadCount(),
                cpu.getTdpWatts()
        );
    }

    public static Cpu toEntity(CpuCreateDto cpuCreateDto) {
        var cpu = new Cpu();

        cpu.setBrand(cpuCreateDto.brand());
        cpu.setModelName(cpuCreateDto.modelName());
        cpu.setPrice(cpuCreateDto.price());
        cpu.setQuantity(cpuCreateDto.quantity());
        cpu.setImageUrls(cpuCreateDto.imageUrls());
        cpu.setSocketType(cpuCreateDto.socketType());
        cpu.setCoreCount(cpuCreateDto.coreCount());
        cpu.setThreadCount(cpuCreateDto.threadCount());
        cpu.setTdpWatts(cpuCreateDto.tdpWatts());

        return cpu;
    }
}
