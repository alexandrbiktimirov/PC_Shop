package org.example.custompcbuilder.controller;

import jakarta.validation.Valid;
import org.example.custompcbuilder.dto.motherboard.MotherboardCreateDto;
import org.example.custompcbuilder.dto.motherboard.MotherboardDto;
import org.example.custompcbuilder.dto.motherboard.MotherboardUpdateDto;
import org.example.custompcbuilder.exception.MotherboardNotFoundException;
import org.example.custompcbuilder.service.MotherboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/motherboards")
public class MotherboardController {

    private final MotherboardService motherboardService;

    public MotherboardController(MotherboardService motherboardService) {
        this.motherboardService = motherboardService;
    }

    @GetMapping
    public ResponseEntity<List<MotherboardDto>> getMotherboards() {
        return ResponseEntity.ok(motherboardService.getMotherboards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotherboardDto> getMotherboardById(@PathVariable Long id) throws MotherboardNotFoundException {
        return ResponseEntity.ok(motherboardService.getMotherboardById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateMotherboard(@PathVariable Long id,
                                                  @RequestBody @Valid MotherboardUpdateDto dto)
            throws MotherboardNotFoundException {
        motherboardService.updateMotherboard(id, dto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<MotherboardDto> createMotherboard(@Valid @RequestBody MotherboardCreateDto dto) {
        var result = motherboardService.createMotherboard(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.id())
                .toUri();

        return ResponseEntity.created(location).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotherboard(@PathVariable Long id) {
        motherboardService.deleteMotherboard(id);
        return ResponseEntity.noContent().build();
    }
}