package org.example.custompcbuilder.repository;

import org.example.custompcbuilder.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
