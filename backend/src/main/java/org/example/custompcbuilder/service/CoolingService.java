package org.example.custompcbuilder.service;

import jakarta.transaction.Transactional;
import org.example.custompcbuilder.dto.cooling.CoolingCreateDto;
import org.example.custompcbuilder.dto.cooling.CoolingDto;
import org.example.custompcbuilder.dto.cooling.CoolingUpdateDto;
import org.example.custompcbuilder.exception.CoolingNotFoundException;

import java.util.List;

public interface CoolingService {
    List<CoolingDto> getCoolings();
    CoolingDto getCoolingById(Long id) throws CoolingNotFoundException;

    @Transactional
    CoolingDto createCooling(CoolingCreateDto coolingCreateDto);

    @Transactional
    void updateCooling(Long id, CoolingUpdateDto coolingUpdateDto) throws CoolingNotFoundException;

    void deleteCooling(Long id);
}