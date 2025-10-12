package org.example.custompcbuilder.controller;

import jakarta.validation.Valid;
import org.example.custompcbuilder.dto.ram.RamCreateDto;
import org.example.custompcbuilder.dto.ram.RamDto;
import org.example.custompcbuilder.dto.ram.RamUpdateDto;
import org.example.custompcbuilder.exception.RamNotFoundException;
import org.example.custompcbuilder.service.RamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rams")
public class RamController {

    private final RamService ramService;

    public RamController(RamService ramService) {
        this.ramService = ramService;
    }

    @GetMapping
    public ResponseEntity<List<RamDto>> getRams() {
        return ResponseEntity.ok(ramService.getRams());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RamDto> getRamById(@PathVariable Long id) throws RamNotFoundException {
        return ResponseEntity.ok(ramService.getRamById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateRam(@PathVariable Long id, @RequestBody @Valid RamUpdateDto dto) throws RamNotFoundException {
        ramService.updateRam(id, dto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<RamDto> createRam(@Valid @RequestBody RamCreateDto dto) {
        RamDto result = ramService.createRam(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.id())
                .toUri();

        return ResponseEntity.created(location).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRam(@PathVariable Long id) {
        ramService.deleteRam(id);
        return ResponseEntity.noContent().build();
    }
}