package org.example.custompcbuilder.repository;

import org.example.custompcbuilder.entity.Gpu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GpuRepository extends JpaRepository<Gpu, Long> {
}
