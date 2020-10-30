package com.egorbarinov.springleveltwo.shop.service;


import com.egorbarinov.springleveltwo.shop.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAll();
    void addToUserBucket(Long productId, String username);
    void addProduct(ProductDto dto);
    ProductDto getById(Long id);

}
