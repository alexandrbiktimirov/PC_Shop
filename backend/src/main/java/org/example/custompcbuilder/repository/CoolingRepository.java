package org.example.custompcbuilder.repository;

import org.example.custompcbuilder.entity.Cooling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoolingRepository extends JpaRepository<Cooling, Long> {
}
