package org.example.custompcbuilder.controller;

import jakarta.validation.Valid;
import org.example.custompcbuilder.dto.gpu.GpuCreateDto;
import org.example.custompcbuilder.dto.gpu.GpuDto;
import org.example.custompcbuilder.dto.gpu.GpuUpdateDto;
import org.example.custompcbuilder.exception.GpuNotFoundException;
import org.example.custompcbuilder.service.GpuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/gpus")
public class GpuController {
    private final GpuService gpuService;

    public GpuController(GpuService gpuService) {
        this.gpuService = gpuService;
    }

    @GetMapping
    public ResponseEntity<List<GpuDto>> getGpus() {
        return ResponseEntity.ok(gpuService.getGpus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GpuDto> getGpuById(@PathVariable Long id) throws GpuNotFoundException {
        return ResponseEntity.ok(gpuService.getGpuById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateGpu(@PathVariable Long id, @RequestBody @Valid GpuUpdateDto GpuUpdateDto) throws GpuNotFoundException {
        gpuService.updateGpu(id, GpuUpdateDto);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<GpuDto> createGpu(@Valid @RequestBody GpuCreateDto GpuCreateDto) {
        var result = gpuService.createGpu(GpuCreateDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.id())
                .toUri();

        return ResponseEntity.created(location).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGpu(@PathVariable Long id) {
        gpuService.deleteGpu(id);

        return ResponseEntity.noContent().build();
    }
}
