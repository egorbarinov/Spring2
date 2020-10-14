package pro.bolshakov.geekbrains.springleveltwo.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.bolshakov.geekbrains.springleveltwo.shop.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
