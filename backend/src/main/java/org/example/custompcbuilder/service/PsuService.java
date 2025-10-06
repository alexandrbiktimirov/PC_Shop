package org.example.custompcbuilder.service;

import jakarta.transaction.Transactional;
import org.example.custompcbuilder.dto.psu.PsuCreateDto;
import org.example.custompcbuilder.dto.psu.PsuDto;
import org.example.custompcbuilder.dto.psu.PsuUpdateDto;
import org.example.custompcbuilder.exception.PsuNotFoundException;

import java.util.List;

public interface PsuService {
    List<PsuDto> getPsus();
    PsuDto getPsuById(Long id) throws PsuNotFoundException;

    @Transactional
    PsuDto createPsu(PsuCreateDto psuCreateDto);

    @Transactional
    void updatePsu(Long id, PsuUpdateDto psuUpdateDto) throws PsuNotFoundException;

    void deletePsu(Long id);
}