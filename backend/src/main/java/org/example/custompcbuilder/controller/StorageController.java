package org.example.custompcbuilder.controller;

import jakarta.validation.Valid;
import org.example.custompcbuilder.dto.storage.StorageCreateDto;
import org.example.custompcbuilder.dto.storage.StorageDto;
import org.example.custompcbuilder.dto.storage.StorageUpdateDto;
import org.example.custompcbuilder.exception.StorageNotFoundException;
import org.example.custompcbuilder.service.StorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/storages")
public class StorageController {

    private final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping
    public ResponseEntity<List<StorageDto>> getStorages() {
        return ResponseEntity.ok(storageService.getStorages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StorageDto> getStorageById(@PathVariable Long id) throws StorageNotFoundException {
        return ResponseEntity.ok(storageService.getStorageById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateStorage(@PathVariable Long id, @RequestBody @Valid StorageUpdateDto dto) throws StorageNotFoundException {
        storageService.updateStorage(id, dto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<StorageDto> createStorage(@Valid @RequestBody StorageCreateDto dto) {
        StorageDto result = storageService.createStorage(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.id())
                .toUri();

        return ResponseEntity.created(location).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStorage(@PathVariable Long id) {
        storageService.deleteStorage(id);
        return ResponseEntity.noContent().build();
    }
}