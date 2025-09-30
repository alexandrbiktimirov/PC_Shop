package org.example.custompcbuilder.controller;

import jakarta.validation.Valid;
import org.example.custompcbuilder.dto.cpu.CpuCreateDto;
import org.example.custompcbuilder.dto.cpu.CpuDto;
import org.example.custompcbuilder.dto.cpu.CpuUpdateDto;
import org.example.custompcbuilder.exception.CpuNotFoundException;
import org.example.custompcbuilder.service.CpuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cpus")
public class CpuController {
    private final CpuService cpuService;

    public CpuController(CpuService cpuService) {
        this.cpuService = cpuService;
    }

    @GetMapping
    public ResponseEntity<List<CpuDto>> getCpus() {
        return ResponseEntity.ok(cpuService.getCpus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CpuDto> getCpuById(@PathVariable Long id) throws CpuNotFoundException {
        return ResponseEntity.ok(cpuService.getCpuById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateCpu(@PathVariable Long id, @RequestBody @Valid CpuUpdateDto cpuUpdateDto) throws CpuNotFoundException {
        cpuService.updateCpu(id, cpuUpdateDto);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<CpuDto> createCpu(@Valid @RequestBody CpuCreateDto cpuCreateDto) {
        var result = cpuService.createCpu(cpuCreateDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.id())
                .toUri();

        return ResponseEntity.created(location).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCpu(@PathVariable Long id) {
        cpuService.deleteCpu(id);

        return ResponseEntity.noContent().build();
    }
}
