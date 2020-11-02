package com.egorbarinov.springleveltwo.shop.controller;

import com.egorbarinov.springleveltwo.shop.dto.ProductDto;
import com.egorbarinov.springleveltwo.shop.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductController2IT {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ProductService productService;

    private ProductDto expectedProduct = new ProductDto(99L, "Test Product", 999.99);

    @BeforeEach
    void setUp() {
        given(productService.getById(expectedProduct.getId()))
                .willReturn(expectedProduct);
    }

    @Test
    void getById() {
        //execute
        ResponseEntity<ProductDto> entity =
                restTemplate
                        .getForEntity("/products/" + expectedProduct.getId(), ProductDto.class);
        //check
        Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());

        ProductDto actualProduct = entity.getBody();
        Assertions.assertEquals(expectedProduct, actualProduct);


    }
}