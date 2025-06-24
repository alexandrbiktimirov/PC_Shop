package org.example.custompcbuilder.repository;

import org.example.custompcbuilder.entity.Build;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildRepository extends JpaRepository<Build, Long> {
}
