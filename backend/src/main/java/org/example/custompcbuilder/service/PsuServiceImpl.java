package org.example.custompcbuilder.service;

import jakarta.transaction.Transactional;
import org.example.custompcbuilder.dto.psu.PsuCreateDto;
import org.example.custompcbuilder.dto.psu.PsuDto;
import org.example.custompcbuilder.dto.psu.PsuUpdateDto;
import org.example.custompcbuilder.entity.Psu;
import org.example.custompcbuilder.exception.PsuNotFoundException;
import org.example.custompcbuilder.mapper.PsuMapper;
import org.example.custompcbuilder.repository.PsuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PsuServiceImpl implements PsuService {
    private final PsuRepository psuRepository;

    public PsuServiceImpl(PsuRepository psuRepository) {
        this.psuRepository = psuRepository;
    }

    @Override
    public List<PsuDto> getPsus() {
        return psuRepository.findAll()
                .stream()
                .map(PsuMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PsuDto getPsuById(Long id) throws PsuNotFoundException {
        Psu psu = psuRepository.findById(id).orElseThrow(() -> new PsuNotFoundException("This PSU was not found :("));
        return PsuMapper.toDto(psu);
    }

    @Transactional
    @Override
    public PsuDto createPsu(PsuCreateDto psuCreateDto) {
        Psu psu = PsuMapper.toEntity(psuCreateDto);
        psu = psuRepository.save(psu);
        return PsuMapper.toDto(psu);
    }

    @Transactional
    @Override
    public void updatePsu(Long id, PsuUpdateDto psuUpdateDto) throws PsuNotFoundException {
        Psu psu = psuRepository.findById(id).orElseThrow(() -> new PsuNotFoundException("This PSU was not found :("));

        if (psuUpdateDto.modelName() != null) {
            psu.setModelName(psuUpdateDto.modelName());
        }
        if (psuUpdateDto.brand() != null) {
            psu.setBrand(psuUpdateDto.brand());
        }
        if (psuUpdateDto.price() != null) {
            psu.setPrice(psuUpdateDto.price());
        }
        if (psuUpdateDto.quantity() != null) {
            psu.setQuantity(psuUpdateDto.quantity());
        }
        if (psuUpdateDto.imageUrls() != null) {
            psu.setImageUrls(psuUpdateDto.imageUrls());
        }
        if (psuUpdateDto.wattage() != null) {
            psu.setWattage(psuUpdateDto.wattage());
        }
        if (psuUpdateDto.formFactor() != null) {
            psu.setFormFactor(psuUpdateDto.formFactor());
        }

        psuRepository.save(psu);
    }

    @Override
    public void deletePsu(Long id) {
        psuRepository.deleteById(id);
    }
}