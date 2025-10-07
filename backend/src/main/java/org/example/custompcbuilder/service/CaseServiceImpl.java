package org.example.custompcbuilder.service;

import jakarta.transaction.Transactional;
import org.example.custompcbuilder.dto.cases.CaseCreateDto;
import org.example.custompcbuilder.dto.cases.CaseDto;
import org.example.custompcbuilder.dto.cases.CaseUpdateDto;
import org.example.custompcbuilder.entity.Case;
import org.example.custompcbuilder.exception.CaseNotFoundException;
import org.example.custompcbuilder.mapper.CaseMapper;
import org.example.custompcbuilder.repository.CaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaseServiceImpl implements CaseService {

    private final CaseRepository caseRepository;

    public CaseServiceImpl(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    @Override
    public List<CaseDto> getCases() {
        return caseRepository.findAll()
                .stream()
                .map(CaseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CaseDto getCaseById(Long id) throws CaseNotFoundException {
        Case c = caseRepository.findById(id)
                .orElseThrow(() -> new CaseNotFoundException("This case was not found :("));
        return CaseMapper.toDto(c);
    }

    @Transactional
    @Override
    public CaseDto createCase(CaseCreateDto caseCreateDto) {
        Case c = CaseMapper.toEntity(caseCreateDto);
        c = caseRepository.save(c);
        return CaseMapper.toDto(c);
    }

    @Transactional
    @Override
    public void updateCase(Long id, CaseUpdateDto caseUpdateDto) throws CaseNotFoundException {
        Case c = caseRepository.findById(id)
                .orElseThrow(() -> new CaseNotFoundException("This case was not found :("));

        if (caseUpdateDto.modelName() != null) c.setModelName(caseUpdateDto.modelName());
        if (caseUpdateDto.brand() != null) c.setBrand(caseUpdateDto.brand());
        if (caseUpdateDto.price() != null) c.setPrice(caseUpdateDto.price());
        if (caseUpdateDto.quantity() != null) c.setQuantity(caseUpdateDto.quantity());
        if (caseUpdateDto.imageUrls() != null) c.setImageUrls(caseUpdateDto.imageUrls());
        if (caseUpdateDto.formFactorSupport() != null) c.setFormFactorSupport(caseUpdateDto.formFactorSupport());
        if (caseUpdateDto.maxGpuLengthMm() != null) c.setMaxGpuLengthMm(caseUpdateDto.maxGpuLengthMm());

        caseRepository.save(c);
    }

    @Override
    public void deleteCase(Long id) {
        caseRepository.deleteById(id);
    }
}