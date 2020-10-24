package com.egorbarinov.springleveltwo.shop.dao;

import com.egorbarinov.springleveltwo.shop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
