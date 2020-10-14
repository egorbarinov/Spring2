package pro.bolshakov.geekbrains.springleveltwo.shop.service;

import org.springframework.stereotype.Service;
import pro.bolshakov.geekbrains.springleveltwo.shop.dao.ProductRepository;
import pro.bolshakov.geekbrains.springleveltwo.shop.dto.ProductDto;
import pro.bolshakov.geekbrains.springleveltwo.shop.mapper.ProductMapper;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper mapper = ProductMapper.MAPPER;

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getAll() {
        return mapper.fromProductList(productRepository.findAll());
    }
}
