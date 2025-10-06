package org.example.custompcbuilder.controller;

import jakarta.validation.Valid;
import org.example.custompcbuilder.dto.psu.PsuCreateDto;
import org.example.custompcbuilder.dto.psu.PsuDto;
import org.example.custompcbuilder.dto.psu.PsuUpdateDto;
import org.example.custompcbuilder.exception.PsuNotFoundException;
import org.example.custompcbuilder.service.PsuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/psus")
public class PsuController {

    private final PsuService psuService;

    public PsuController(PsuService psuService) {
        this.psuService = psuService;
    }

    @GetMapping
    public ResponseEntity<List<PsuDto>> getPsus() {
        return ResponseEntity.ok(psuService.getPsus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PsuDto> getPsuById(@PathVariable Long id) throws PsuNotFoundException {
        return ResponseEntity.ok(psuService.getPsuById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePsu(@PathVariable Long id, @RequestBody @Valid PsuUpdateDto psuUpdateDto) throws PsuNotFoundException {
        psuService.updatePsu(id, psuUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<PsuDto> createPsu(@Valid @RequestBody PsuCreateDto psuCreateDto) {
        var result = psuService.createPsu(psuCreateDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.id())
                .toUri();

        return ResponseEntity.created(location).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePsu(@PathVariable Long id) {
        psuService.deletePsu(id);
        return ResponseEntity.noContent().build();
    }
}