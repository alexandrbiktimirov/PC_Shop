package org.example.custompcbuilder.service;

import jakarta.transaction.Transactional;
import org.example.custompcbuilder.dto.ram.RamCreateDto;
import org.example.custompcbuilder.dto.ram.RamDto;
import org.example.custompcbuilder.dto.ram.RamUpdateDto;
import org.example.custompcbuilder.entity.Ram;
import org.example.custompcbuilder.exception.RamNotFoundException;
import org.example.custompcbuilder.mapper.RamMapper;
import org.example.custompcbuilder.repository.RamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RamServiceImpl implements RamService {

    private final RamRepository ramRepository;

    public RamServiceImpl(RamRepository ramRepository) {
        this.ramRepository = ramRepository;
    }

    @Override
    public List<RamDto> getRams() {
        return ramRepository.findAll()
                .stream()
                .map(RamMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RamDto getRamById(Long id) throws RamNotFoundException {
        Ram ram = ramRepository.findById(id)
                .orElseThrow(() -> new RamNotFoundException("This RAM was not found :("));
        return RamMapper.toDto(ram);
    }

    @Transactional
    @Override
    public RamDto createRam(RamCreateDto dto) {
        Ram ram = RamMapper.toEntity(dto);
        ram = ramRepository.save(ram);
        return RamMapper.toDto(ram);
    }

    @Transactional
    @Override
    public void updateRam(Long id, RamUpdateDto dto) throws RamNotFoundException {
        Ram ram = ramRepository.findById(id)
                .orElseThrow(() -> new RamNotFoundException("This RAM was not found :("));

        if (dto.modelName() != null) ram.setModelName(dto.modelName());
        if (dto.brand() != null) ram.setBrand(dto.brand());
        if (dto.price() != null) ram.setPrice(dto.price());
        if (dto.quantity() != null) ram.setQuantity(dto.quantity());
        if (dto.imageUrls() != null) ram.setImageUrls(dto.imageUrls());
        if (dto.type() != null) ram.setType(dto.type());
        if (dto.totalCapacitySize() != null) ram.setTotalCapacitySize(dto.totalCapacitySize());
        if (dto.speedMhz() != null) ram.setSpeedMhz(dto.speedMhz());

        ramRepository.save(ram);
    }

    @Override
    public void deleteRam(Long id) {
        ramRepository.deleteById(id);
    }
}