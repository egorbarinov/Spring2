package com.egorbarinov.springleveltwo.springintegration.service;

import com.egorbarinov.springleveltwo.springintegration.dao.OrderRepository;
import com.egorbarinov.springleveltwo.springintegration.domain.Order;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final static Logger logger = LoggerFactory.getLogger(Order.class);

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void save(Order order) throws IOException {
//
//        ObjectMapper mapper = new ObjectMapper();
//        String orderAsString = mapper.writeValueAsString(order);
//        order = mapper.readValue(orderAsString, Order.class);
        orderRepository.save(order);
        logger.info("All records saved.");
    }
}
