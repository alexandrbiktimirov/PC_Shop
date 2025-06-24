package org.example.custompcbuilder.repository;

import org.example.custompcbuilder.entity.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CpuRepository extends JpaRepository<Cpu, Long> {
}
