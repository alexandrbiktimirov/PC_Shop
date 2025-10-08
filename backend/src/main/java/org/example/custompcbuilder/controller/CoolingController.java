package org.example.custompcbuilder.controller;

import jakarta.validation.Valid;
import org.example.custompcbuilder.dto.cooling.CoolingCreateDto;
import org.example.custompcbuilder.dto.cooling.CoolingDto;
import org.example.custompcbuilder.dto.cooling.CoolingUpdateDto;
import org.example.custompcbuilder.exception.CoolingNotFoundException;
import org.example.custompcbuilder.service.CoolingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/coolings")
public class CoolingController {

    private final CoolingService coolingService;

    public CoolingController(CoolingService coolingService) {
        this.coolingService = coolingService;
    }

    @GetMapping
    public ResponseEntity<List<CoolingDto>> getCoolings() {
        return ResponseEntity.ok(coolingService.getCoolings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoolingDto> getCoolingById(@PathVariable Long id) throws CoolingNotFoundException {
        return ResponseEntity.ok(coolingService.getCoolingById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateCooling(@PathVariable Long id,
                                              @RequestBody @Valid CoolingUpdateDto dto) throws CoolingNotFoundException {
        coolingService.updateCooling(id, dto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<CoolingDto> createCooling(@Valid @RequestBody CoolingCreateDto dto) {
        var result = coolingService.createCooling(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.id())
                .toUri();

        return ResponseEntity.created(location).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCooling(@PathVariable Long id) {
        coolingService.deleteCooling(id);
        return ResponseEntity.noContent().build();
    }
}