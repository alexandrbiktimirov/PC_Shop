package org.example.custompcbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.custompcbuilder.entity.Thread;

public interface ThreadRepository extends JpaRepository<Thread, Long> {
}
