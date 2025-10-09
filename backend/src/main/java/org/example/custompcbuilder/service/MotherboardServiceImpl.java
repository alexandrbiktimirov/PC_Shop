package org.example.custompcbuilder.service;

import jakarta.transaction.Transactional;
import org.example.custompcbuilder.dto.motherboard.MotherboardCreateDto;
import org.example.custompcbuilder.dto.motherboard.MotherboardDto;
import org.example.custompcbuilder.dto.motherboard.MotherboardUpdateDto;
import org.example.custompcbuilder.entity.Motherboard;
import org.example.custompcbuilder.exception.MotherboardNotFoundException;
import org.example.custompcbuilder.mapper.MotherboardMapper;
import org.example.custompcbuilder.repository.MotherboardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotherboardServiceImpl implements MotherboardService {

    private final MotherboardRepository motherboardRepository;

    public MotherboardServiceImpl(MotherboardRepository motherboardRepository) {
        this.motherboardRepository = motherboardRepository;
    }

    @Override
    public List<MotherboardDto> getMotherboards() {
        return motherboardRepository.findAll()
                .stream()
                .map(MotherboardMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MotherboardDto getMotherboardById(Long id) throws MotherboardNotFoundException {
        Motherboard mb = motherboardRepository.findById(id)
                .orElseThrow(() -> new MotherboardNotFoundException("This motherboard was not found :("));
        return MotherboardMapper.toDto(mb);
    }

    @Transactional
    @Override
    public MotherboardDto createMotherboard(MotherboardCreateDto dto) {
        Motherboard mb = MotherboardMapper.toEntity(dto);
        mb = motherboardRepository.save(mb);
        return MotherboardMapper.toDto(mb);
    }

    @Transactional
    @Override
    public void updateMotherboard(Long id, MotherboardUpdateDto dto) throws MotherboardNotFoundException {
        Motherboard mb = motherboardRepository.findById(id)
                .orElseThrow(() -> new MotherboardNotFoundException("This motherboard was not found :("));

        if (dto.modelName() != null) mb.setModelName(dto.modelName());
        if (dto.brand() != null) mb.setBrand(dto.brand());
        if (dto.price() != null) mb.setPrice(dto.price());
        if (dto.quantity() != null) mb.setQuantity(dto.quantity());
        if (dto.imageUrls() != null) mb.setImageUrls(dto.imageUrls());
        if (dto.socketType() != null) mb.setSocketType(dto.socketType());
        if (dto.formFactor() != null) mb.setFormFactor(dto.formFactor());
        if (dto.supportedMemoryType() != null) mb.setSupportedMemoryType(dto.supportedMemoryType());

        motherboardRepository.save(mb);
    }

    @Override
    public void deleteMotherboard(Long id) {
        motherboardRepository.deleteById(id);
    }
}