package com.icommerce.product.core.product.port;

import com.icommerce.product.core.product.Product;

import java.util.List;

public interface ProductPersistencePort {

    List<Product> find(String search, String sort, Integer size, Integer page);
    String create(Product product);
}
