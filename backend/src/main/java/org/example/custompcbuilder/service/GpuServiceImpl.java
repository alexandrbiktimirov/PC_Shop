package org.example.custompcbuilder.service;

import org.example.custompcbuilder.dto.gpu.GpuCreateDto;
import org.example.custompcbuilder.dto.gpu.GpuDto;
import org.example.custompcbuilder.dto.gpu.GpuUpdateDto;
import org.example.custompcbuilder.exception.GpuNotFoundException;
import org.example.custompcbuilder.repository.GpuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GpuServiceImpl implements GpuService {
    private final GpuRepository gpuRepository;

    public GpuServiceImpl(GpuRepository gpuRepository) {
        this.gpuRepository = gpuRepository;
    }

    @Override
    public List<GpuDto> getGpus() {
        return List.of();
    }

    @Override
    public GpuDto getGpuById(Long id) throws GpuNotFoundException {
        return null;
    }

    @Override
    public GpuDto createGpu(GpuCreateDto gpuCreateDto) {
        return null;
    }

    @Override
    public void updateGpu(Long id, GpuUpdateDto gpuUpdateDto) throws GpuNotFoundException {

    }

    @Override
    public void deleteGpu(Long id) {

    }
}
