package org.example.custompcbuilder.service;

import jakarta.transaction.Transactional;
import org.example.custompcbuilder.dto.cooling.CoolingCreateDto;
import org.example.custompcbuilder.dto.cooling.CoolingDto;
import org.example.custompcbuilder.dto.cooling.CoolingUpdateDto;
import org.example.custompcbuilder.entity.Cooling;
import org.example.custompcbuilder.exception.CoolingNotFoundException;
import org.example.custompcbuilder.mapper.CoolingMapper;
import org.example.custompcbuilder.repository.CoolingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoolingServiceImpl implements CoolingService {

    private final CoolingRepository coolingRepository;

    public CoolingServiceImpl(CoolingRepository coolingRepository) {
        this.coolingRepository = coolingRepository;
    }

    @Override
    public List<CoolingDto> getCoolings() {
        return coolingRepository.findAll()
                .stream()
                .map(CoolingMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CoolingDto getCoolingById(Long id) throws CoolingNotFoundException {
        Cooling c = coolingRepository.findById(id)
                .orElseThrow(() -> new CoolingNotFoundException("This cooling was not found :("));
        return CoolingMapper.toDto(c);
    }

    @Transactional
    @Override
    public CoolingDto createCooling(CoolingCreateDto dto) {
        Cooling c = CoolingMapper.toEntity(dto);
        c = coolingRepository.save(c);
        return CoolingMapper.toDto(c);
    }

    @Transactional
    @Override
    public void updateCooling(Long id, CoolingUpdateDto dto) throws CoolingNotFoundException {
        Cooling c = coolingRepository.findById(id)
                .orElseThrow(() -> new CoolingNotFoundException("This cooling was not found :("));

        if (dto.modelName() != null) c.setModelName(dto.modelName());
        if (dto.brand() != null) c.setBrand(dto.brand());
        if (dto.price() != null) c.setPrice(dto.price());
        if (dto.quantity() != null) c.setQuantity(dto.quantity());
        if (dto.imageUrls() != null) c.setImageUrls(dto.imageUrls());
        if (dto.type() != null) c.setType(dto.type());
        if (dto.supportedSockets() != null) c.setSupportedSockets(dto.supportedSockets());
        if (dto.tdpWattsRating() != null) c.setTdpWattsRating(dto.tdpWattsRating());

        coolingRepository.save(c);
    }

    @Override
    public void deleteCooling(Long id) {
        coolingRepository.deleteById(id);
    }
}