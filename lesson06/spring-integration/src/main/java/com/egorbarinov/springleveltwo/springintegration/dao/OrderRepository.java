package com.egorbarinov.springleveltwo.springintegration.dao;

import com.egorbarinov.springleveltwo.springintegration.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
