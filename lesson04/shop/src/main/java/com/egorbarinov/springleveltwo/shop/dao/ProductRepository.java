package com.egorbarinov.springleveltwo.shop.dao;


import com.egorbarinov.springleveltwo.shop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
