package pro.bolshakov.geekbrains.springleveltwo.shop.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import pro.bolshakov.geekbrains.springleveltwo.shop.domain.Product;
import pro.bolshakov.geekbrains.springleveltwo.shop.dto.ProductDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-15T13:06:25+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_251 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(ProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( dto.getId() );
        product.setTitle( dto.getTitle() );
        product.setPrice( dto.getPrice() );

        return product;
    }

    @Override
    public ProductDto fromProduct(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setTitle( product.getTitle() );
        productDto.setPrice( product.getPrice() );

        return productDto;
    }

    @Override
    public List<Product> toProductList(List<ProductDto> productDtos) {
        if ( productDtos == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productDtos.size() );
        for ( ProductDto productDto : productDtos ) {
            list.add( toProduct( productDto ) );
        }

        return list;
    }

    @Override
    public List<ProductDto> fromProductList(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( products.size() );
        for ( Product product : products ) {
            list.add( fromProduct( product ) );
        }

        return list;
    }
}
