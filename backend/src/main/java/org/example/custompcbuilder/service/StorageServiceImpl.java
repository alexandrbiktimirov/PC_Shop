package org.example.custompcbuilder.service;

import jakarta.transaction.Transactional;
import org.example.custompcbuilder.dto.storage.StorageCreateDto;
import org.example.custompcbuilder.dto.storage.StorageDto;
import org.example.custompcbuilder.dto.storage.StorageUpdateDto;
import org.example.custompcbuilder.entity.Storage;
import org.example.custompcbuilder.exception.StorageNotFoundException;
import org.example.custompcbuilder.mapper.StorageMapper;
import org.example.custompcbuilder.repository.StorageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StorageServiceImpl implements StorageService {

    private final StorageRepository storageRepository;

    public StorageServiceImpl(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    @Override
    public List<StorageDto> getStorages() {
        return storageRepository.findAll()
                .stream()
                .map(StorageMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StorageDto getStorageById(Long id) throws StorageNotFoundException {
        Storage s = storageRepository.findById(id)
                .orElseThrow(() -> new StorageNotFoundException("This storage device was not found :("));
        return StorageMapper.toDto(s);
    }

    @Transactional
    @Override
    public StorageDto createStorage(StorageCreateDto dto) {
        Storage s = StorageMapper.toEntity(dto);
        s = storageRepository.save(s);
        return StorageMapper.toDto(s);
    }

    @Transactional
    @Override
    public void updateStorage(Long id, StorageUpdateDto dto) throws StorageNotFoundException {
        Storage s = storageRepository.findById(id)
                .orElseThrow(() -> new StorageNotFoundException("This storage device was not found :("));

        if (dto.modelName() != null) s.setModelName(dto.modelName());
        if (dto.brand() != null) s.setBrand(dto.brand());
        if (dto.price() != null) s.setPrice(dto.price());
        if (dto.quantity() != null) s.setQuantity(dto.quantity());
        if (dto.imageUrls() != null) s.setImageUrls(dto.imageUrls());
        if (dto.type() != null) s.setType(dto.type());
        if (dto.formFactor() != null) s.setFormFactor(dto.formFactor());
        if (dto.capacityGb() != null) s.setCapacityGb(dto.capacityGb());

        storageRepository.save(s);
    }

    @Override
    public void deleteStorage(Long id) {
        storageRepository.deleteById(id);
    }
}