package org.example.custompcbuilder.service;

import jakarta.transaction.Transactional;
import org.example.custompcbuilder.dto.gpu.GpuCreateDto;
import org.example.custompcbuilder.dto.gpu.GpuDto;
import org.example.custompcbuilder.dto.gpu.GpuUpdateDto;
import org.example.custompcbuilder.entity.Gpu;
import org.example.custompcbuilder.exception.GpuNotFoundException;
import org.example.custompcbuilder.mapper.GpuMapper;
import org.example.custompcbuilder.repository.GpuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GpuServiceImpl implements GpuService {
    private final GpuRepository gpuRepository;

    public GpuServiceImpl(GpuRepository gpuRepository) {
        this.gpuRepository = gpuRepository;
    }

    @Override
    public List<GpuDto> getGpus() {
        return gpuRepository.findAll()
                .stream()
                .map(GpuMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public GpuDto getGpuById(Long id) throws GpuNotFoundException {
        Gpu gpu = gpuRepository.findById(id).orElseThrow(() -> new GpuNotFoundException("This GPU was not found :("));

        return GpuMapper.toDto(gpu);
    }

    @Transactional
    @Override
    public GpuDto createGpu(GpuCreateDto gpuCreateDto) {
        Gpu gpu = GpuMapper.toEntity(gpuCreateDto);

        gpu = gpuRepository.save(gpu);

        return GpuMapper.toDto(gpu);
    }

    @Transactional
    @Override
    public void updateGpu(Long id, GpuUpdateDto gpuUpdateDto) throws GpuNotFoundException {
        Gpu gpu = gpuRepository.findById(id).orElseThrow(() -> new GpuNotFoundException("This GPU was not found :("));

        if (gpuUpdateDto.modelName() != null){
            gpu.setModelName(gpuUpdateDto.modelName());
        }

        if (gpuUpdateDto.brand() != null){
            gpu.setBrand(gpuUpdateDto.brand());
        }

        if (gpuUpdateDto.price() != null) {
            gpu.setPrice(gpuUpdateDto.price());
        }

        if (gpuUpdateDto.quantity() != null){
            gpu.setQuantity(gpuUpdateDto.quantity());
        }

        if (gpuUpdateDto.imageUrls() != null){
            gpu.setImageUrls(gpuUpdateDto.imageUrls());
        }

        if (gpuUpdateDto.memorySizeGb() != null) {
            gpu.setMemorySizeGb(gpuUpdateDto.memorySizeGb());
        }

        if (gpuUpdateDto.tdpWatts() != null){
            gpu.setTdpWatts(gpuUpdateDto.tdpWatts());
        }

        if (gpuUpdateDto.lengthMm() != null) {
            gpu.setLengthMm(gpuUpdateDto.lengthMm());
        }

        gpuRepository.save(gpu);
    }

    @Transactional
    @Override
    public void deleteGpu(Long id) {
        gpuRepository.deleteById(id);
    }
}
