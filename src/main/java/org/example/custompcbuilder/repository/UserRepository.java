package org.example.custompcbuilder.repository;

import org.example.custompcbuilder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
