package org.example.custompcbuilder.controller;

import jakarta.validation.Valid;
import org.example.custompcbuilder.dto.cases.CaseCreateDto;
import org.example.custompcbuilder.dto.cases.CaseDto;
import org.example.custompcbuilder.dto.cases.CaseUpdateDto;
import org.example.custompcbuilder.exception.CaseNotFoundException;
import org.example.custompcbuilder.service.CaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cases")
public class CaseController {

    private final CaseService caseService;

    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    @GetMapping
    public ResponseEntity<List<CaseDto>> getCases() {
        return ResponseEntity.ok(caseService.getCases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaseDto> getCaseById(@PathVariable Long id) throws CaseNotFoundException {
        return ResponseEntity.ok(caseService.getCaseById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateCase(@PathVariable Long id, @RequestBody @Valid CaseUpdateDto caseUpdateDto)
            throws CaseNotFoundException {
        caseService.updateCase(id, caseUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<CaseDto> createCase(@Valid @RequestBody CaseCreateDto caseCreateDto) {
        var result = caseService.createCase(caseCreateDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.id())
                .toUri();

        return ResponseEntity.created(location).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCase(@PathVariable Long id) {
        caseService.deleteCase(id);
        return ResponseEntity.noContent().build();
    }
}