package com.egorbarinov.springleveltwo.shop.service;

import com.egorbarinov.springleveltwo.shop.dao.OrderRepository;
import com.egorbarinov.springleveltwo.shop.domain.Order;
import com.egorbarinov.springleveltwo.shop.dto.OrderIntegrationDto;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;


    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public void saveOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        sendIntegrationNotify(savedOrder);
    }

    // готовит сообщение для отпрвки и отправляет егов канал
    private void sendIntegrationNotify(Order order){
        OrderIntegrationDto dto = new OrderIntegrationDto();
        dto.setUsername(order.getUser().getName());
        dto.setAddress(order.getAddress());
        dto.setOrderId(order.getId());
        List<OrderIntegrationDto.OrderDetailsDto> details = order.getDetails().stream()
                .map(OrderIntegrationDto.OrderDetailsDto::new).collect(Collectors.toList());
        dto.setDetails(details);

    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
