package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    public void connection() {
//        productRepository.connection();
//    }

    public Product findProduct(int id) {
        return productRepository.findProduct(id);
    }

    @Transactional
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findProducts() {
        return productRepository.findProducts();
    }
}
