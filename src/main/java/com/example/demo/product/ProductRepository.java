package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class ProductRepository {

    @Autowired
    EntityManager entityManager;
//    DataSource dataSource;

    private Map<Integer, Product> db = new HashMap<>();
    private int id = 1;

//    public void connection() {
//        DataSourceUtils.getConnection(dataSource);
//    }

    public Product findProduct(int id) {
        return db.get(id);
    }

    public Product save(Product product) {
        System.out.println(product.getName());
//        db.put(id++, product);
        entityManager.persist(product);
        return product;
    }

    public List<Product> findProducts() {
//        return new ArrayList<>(db.values());
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        List<Product> products = query.getResultList();

        return products;
    }
}
