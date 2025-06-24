package org.example.custompcbuilder.repository;

import org.example.custompcbuilder.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<Case, Long> {
}
