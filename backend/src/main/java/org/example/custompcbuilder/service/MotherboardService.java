package org.example.custompcbuilder.service;

import jakarta.transaction.Transactional;
import org.example.custompcbuilder.dto.motherboard.MotherboardCreateDto;
import org.example.custompcbuilder.dto.motherboard.MotherboardDto;
import org.example.custompcbuilder.dto.motherboard.MotherboardUpdateDto;
import org.example.custompcbuilder.exception.MotherboardNotFoundException;

import java.util.List;

public interface MotherboardService {
    List<MotherboardDto> getMotherboards();
    MotherboardDto getMotherboardById(Long id) throws MotherboardNotFoundException;

    @Transactional
    MotherboardDto createMotherboard(MotherboardCreateDto motherboardCreateDto);

    @Transactional
    void updateMotherboard(Long id, MotherboardUpdateDto motherboardUpdateDto) throws MotherboardNotFoundException;

    void deleteMotherboard(Long id);
}