package com.egorbarinov.springleveltwo.shop.endpoint;

import com.egorbarinov.springleveltwo.shop.dto.ProductDto;
import com.egorbarinov.springleveltwo.shop.service.ProductService;
import com.egorbarinov.springleveltwo.shop.ws.products.GetProductsRequest;
import com.egorbarinov.springleveltwo.shop.ws.products.GetProductsResponse;
import com.egorbarinov.springleveltwo.shop.ws.products.ProductWS;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;

@Endpoint
public class ProductsEndpoint {

    public static final String NAMESPACE_URL = "http://egorbarinov.com/springleveltwo/shop/ws/products";

    private final ProductService productService;

    public ProductsEndpoint(ProductService productService) {

        this.productService = productService;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getProductsRequest")
    @ResponsePayload
    public GetProductsResponse getProducts() {
        GetProductsResponse response = new GetProductsResponse();
        productService.getAll()
                .forEach(dto -> response.getProducts().add(createProductWS(dto)));
        return response;
    }

    private ProductWS createProductWS(ProductDto dto){
        ProductWS ws = new ProductWS();
        ws.setId(dto.getId());
        ws.setTitle(dto.getTitle());
        ws.setPrice(dto.getPrice());
        return ws;
    }
}
