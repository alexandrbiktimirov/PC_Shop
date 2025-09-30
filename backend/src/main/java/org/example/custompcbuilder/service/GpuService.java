package org.example.custompcbuilder.service;

import jakarta.transaction.Transactional;
import org.example.custompcbuilder.dto.gpu.GpuCreateDto;
import org.example.custompcbuilder.dto.gpu.GpuDto;
import org.example.custompcbuilder.dto.gpu.GpuUpdateDto;
import org.example.custompcbuilder.exception.GpuNotFoundException;

import java.util.List;

public interface GpuService {
    List<GpuDto> getGpus();
    GpuDto getGpuById(Long id) throws GpuNotFoundException;
    @Transactional
    GpuDto createGpu(GpuCreateDto gpuCreateDto);
    @Transactional
    void updateGpu(Long id, GpuUpdateDto gpuUpdateDto) throws GpuNotFoundException;
    void deleteGpu(Long id);
}
