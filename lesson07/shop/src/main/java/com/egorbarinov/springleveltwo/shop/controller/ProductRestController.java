package com.egorbarinov.springleveltwo.shop.controller;

import com.egorbarinov.springleveltwo.shop.dto.ProductDto;
import com.egorbarinov.springleveltwo.shop.service.ProductService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {

    private final ProductService productService;


    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PostMapping
    public void addProduct(@RequestBody ProductDto dto){
        productService.addProduct(dto);
    }

}
