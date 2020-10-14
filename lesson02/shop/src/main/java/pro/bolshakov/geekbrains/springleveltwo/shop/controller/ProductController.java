package pro.bolshakov.geekbrains.springleveltwo.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.bolshakov.geekbrains.springleveltwo.shop.dto.ProductDto;
import pro.bolshakov.geekbrains.springleveltwo.shop.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String list(Model model){
        List<ProductDto> list = productService.getAll();
        model.addAttribute("products", list);
        return "products";
    }
}
