package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/connect")
    public void ProductController() {
        productService.connection();
    }

    // 전체 상품 조회
    @GetMapping("/products")
    public List<Product> findProducts() {
        return productService.findProducts();
    }

    // 개별 상품 조회
    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable int id) {
        return productService.findProduct(id);
    }

    // 상품 등록
    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
}
