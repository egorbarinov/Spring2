package pro.bolshakov.geekbrains.springleveltwo.shop.service;

import pro.bolshakov.geekbrains.springleveltwo.shop.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAll();
}
