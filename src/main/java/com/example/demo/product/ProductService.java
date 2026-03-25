package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductSpringDataJPARepository springDataJPAProductRepository;

//    private final ProductRepository productRepository;
//
//    @Autowired
//    ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

//    public void connection() {
//        productRepository.connection();
//    }

    public Product findProduct(int id) {
//        return productRepository.findProduct(id);
        if(springDataJPAProductRepository.findById(id).isPresent()) {
            return springDataJPAProductRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void saveProduct(Product product) {
//        productRepository.save(product);
        springDataJPAProductRepository.save(product);
    }

    public List<Product> findProducts() {
//        return productRepository.findProducts();
        return springDataJPAProductRepository.findAll();
    }

    @Transactional
    public void modifyProduct(Product productModify, Integer id) {
        Product product = findProduct(id);
        product.setName(productModify.getName());
        product.setPrice(productModify.getPrice());
        product.setDescription(productModify.getDescription());
    }

    public void deleteProduct(Integer id) {
        springDataJPAProductRepository.deleteById(id);
    }

}
