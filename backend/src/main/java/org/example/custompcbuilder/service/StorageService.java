package org.example.custompcbuilder.service;

import jakarta.transaction.Transactional;
import org.example.custompcbuilder.dto.storage.StorageCreateDto;
import org.example.custompcbuilder.dto.storage.StorageDto;
import org.example.custompcbuilder.dto.storage.StorageUpdateDto;
import org.example.custompcbuilder.exception.StorageNotFoundException;

import java.util.List;

public interface StorageService {
    List<StorageDto> getStorages();
    StorageDto getStorageById(Long id) throws StorageNotFoundException;
    @Transactional
    StorageDto createStorage(StorageCreateDto dto);
    @Transactional
    void updateStorage(Long id, StorageUpdateDto dto) throws StorageNotFoundException;
    void deleteStorage(Long id);
}