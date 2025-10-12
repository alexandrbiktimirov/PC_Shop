package org.example.custompcbuilder.service;

import jakarta.transaction.Transactional;
import org.example.custompcbuilder.dto.ram.RamCreateDto;
import org.example.custompcbuilder.dto.ram.RamDto;
import org.example.custompcbuilder.dto.ram.RamUpdateDto;
import org.example.custompcbuilder.exception.RamNotFoundException;

import java.util.List;

public interface RamService {
    List<RamDto> getRams();
    RamDto getRamById(Long id) throws RamNotFoundException;
    @Transactional
    RamDto createRam(RamCreateDto dto);
    @Transactional
    void updateRam(Long id, RamUpdateDto dto) throws RamNotFoundException;
    void deleteRam(Long id);
}