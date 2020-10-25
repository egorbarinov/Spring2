package com.egorbarinov.springleveltwo.springintegration.service;

import com.egorbarinov.springleveltwo.springintegration.domain.Order;

import java.io.IOException;

public interface OrderService {
    void save(Order order) throws IOException;

}
