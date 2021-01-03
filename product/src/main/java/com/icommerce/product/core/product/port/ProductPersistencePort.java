package com.icommerce.product.core.product.port;

import com.icommerce.product.core.product.Product;

import java.util.List;

public interface ProductPersistencePort {

    List<Product> find(String search, String sort, Integer size, Integer page);
    String create(Product product);
    Product find(String id);
    Product update(String id, Product product);
}
