package org.example.custompcbuilder.service;

import jakarta.transaction.Transactional;
import org.example.custompcbuilder.dto.cpu.CpuCreateDto;
import org.example.custompcbuilder.dto.cpu.CpuDto;
import org.example.custompcbuilder.dto.cpu.CpuUpdateDto;
import org.example.custompcbuilder.entity.Cpu;
import org.example.custompcbuilder.exception.CpuNotFoundException;
import org.example.custompcbuilder.mapper.CpuMapper;
import org.example.custompcbuilder.repository.CpuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CpuServiceImpl implements CpuService {
    private final CpuRepository cpuRepository;

    public CpuServiceImpl(CpuRepository cpuRepository) {
        this.cpuRepository = cpuRepository;
    }

    @Override
    public List<CpuDto> getCpus() {
        return cpuRepository.findAll()
                .stream()
                .map(CpuMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CpuDto getCpuById(Long id) throws CpuNotFoundException {
        Cpu cpu = cpuRepository.findById(id).orElseThrow(() -> new CpuNotFoundException("This CPU was not found :("));

        return CpuMapper.toDto(cpu);
    }

    @Transactional
    @Override
    public CpuDto createCpu(CpuCreateDto cpuCreateDto) {
        Cpu cpu = CpuMapper.toEntity(cpuCreateDto);

        cpu = cpuRepository.save(cpu);

        return CpuMapper.toDto(cpu);
    }

    @Transactional
    @Override
    public void updateCpu(Long id, CpuUpdateDto cpuUpdateDto) throws CpuNotFoundException {
        Cpu cpu = cpuRepository.findById(id).orElseThrow(() -> new CpuNotFoundException("This CPU was not found :("));

        if (cpuUpdateDto.modelName() != null){
            cpu.setModelName(cpuUpdateDto.modelName());
        }

        if (cpuUpdateDto.brand() != null){
            cpu.setBrand(cpuUpdateDto.brand());
        }

        if (cpuUpdateDto.price() != null) {
            cpu.setPrice(cpuUpdateDto.price());
        }

        if (cpuUpdateDto.quantity() != null){
            cpu.setQuantity(cpuUpdateDto.quantity());
        }

        if (cpuUpdateDto.imageUrls() != null){
            cpu.setImageUrls(cpuUpdateDto.imageUrls());
        }

        if (cpuUpdateDto.socketType() != null){
            cpu.setSocketType(cpuUpdateDto.socketType());
        }

        if (cpuUpdateDto.coreCount() != null){
            cpu.setCoreCount(cpuUpdateDto.coreCount());
        }

        if (cpuUpdateDto.threadCount() != null){
            cpu.setThreadCount(cpuUpdateDto.threadCount());
        }

        if (cpuUpdateDto.tdpWatts() != null){
            cpu.setTdpWatts(cpuUpdateDto.tdpWatts());
        }

        cpuRepository.save(cpu);
    }

    @Override
    public void deleteCpu(Long id) {
        cpuRepository.deleteById(id);
    }
}
