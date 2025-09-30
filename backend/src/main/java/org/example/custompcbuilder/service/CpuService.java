package org.example.custompcbuilder.service;

import jakarta.transaction.Transactional;
import org.example.custompcbuilder.dto.cpu.CpuCreateDto;
import org.example.custompcbuilder.dto.cpu.CpuDto;
import org.example.custompcbuilder.dto.cpu.CpuUpdateDto;
import org.example.custompcbuilder.exception.CpuNotFoundException;

import java.util.List;

public interface CpuService {
    List<CpuDto> getCpus();
    CpuDto getCpuById(Long id) throws CpuNotFoundException;
    @Transactional
    CpuDto createCpu(CpuCreateDto cpuCreateDto);
    @Transactional
    void updateCpu(Long id, CpuUpdateDto cpuUpdateDto) throws CpuNotFoundException;
    void deleteCpu(Long id);
}
