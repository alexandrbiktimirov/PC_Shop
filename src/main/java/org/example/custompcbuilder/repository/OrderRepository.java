package org.example.custompcbuilder.repository;

import org.example.custompcbuilder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
