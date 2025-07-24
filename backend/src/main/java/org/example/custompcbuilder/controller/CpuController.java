package org.example.custompcbuilder.controller;

import jakarta.validation.Valid;
import org.example.custompcbuilder.dto.cpu.CpuCreateDto;
import org.example.custompcbuilder.dto.cpu.CpuDto;
import org.example.custompcbuilder.dto.cpu.CpuUpdateDto;
import org.example.custompcbuilder.exception.CpuNotFound;
import org.example.custompcbuilder.service.CpuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<CpuDto> getCpuById(@PathVariable Long id) throws CpuNotFound {
        return ResponseEntity.ok(cpuService.getCpuById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateCpu(@PathVariable Long id, @RequestBody @Valid CpuUpdateDto cpuUpdateDto) throws CpuNotFound {
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

    @ExceptionHandler(CpuNotFound.class)
    public ResponseEntity<String> handleCpuNotFound(CpuNotFound cpuNotFound) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cpuNotFound.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(errors);
    }
}
