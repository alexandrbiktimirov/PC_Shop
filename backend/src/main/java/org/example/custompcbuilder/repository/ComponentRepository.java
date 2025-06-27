package org.example.custompcbuilder.repository;

import org.example.custompcbuilder.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component, Long> {
}
