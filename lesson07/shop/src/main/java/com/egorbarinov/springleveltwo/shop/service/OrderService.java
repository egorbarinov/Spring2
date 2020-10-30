package com.egorbarinov.springleveltwo.shop.service;

import com.egorbarinov.springleveltwo.shop.domain.Order;

public interface OrderService {
    void saveOrder(Order order);
    Order getOrder(Long id);
}
