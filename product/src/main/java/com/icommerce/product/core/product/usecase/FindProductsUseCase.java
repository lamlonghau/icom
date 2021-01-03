package com.icommerce.product.core.product.usecase;

import com.icommerce.product.core.product.Product;

import java.util.List;

public interface FindProductsUseCase {

    List<Product> execute(String search, String sort, Integer size, Integer page);
    Product execute(String id);
}
