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

//    @GetMapping("/connect")
//    public void ProductController() {
//        productService.connection();
//    }

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
    public void saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    // 상품 수정
    @PutMapping("/products/{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable int id) {
        productService.modifyProduct(product, id);
    }

    // 상품 삭제
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
