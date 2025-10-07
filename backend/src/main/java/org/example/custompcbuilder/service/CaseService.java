package org.example.custompcbuilder.service;

import jakarta.transaction.Transactional;
import org.example.custompcbuilder.dto.cases.CaseCreateDto;
import org.example.custompcbuilder.dto.cases.CaseDto;
import org.example.custompcbuilder.dto.cases.CaseUpdateDto;
import org.example.custompcbuilder.exception.CaseNotFoundException;

import java.util.List;

public interface CaseService {
    List<CaseDto> getCases();
    CaseDto getCaseById(Long id) throws CaseNotFoundException;

    @Transactional
    CaseDto createCase(CaseCreateDto caseCreateDto);

    @Transactional
    void updateCase(Long id, CaseUpdateDto caseUpdateDto) throws CaseNotFoundException;

    void deleteCase(Long id);
}