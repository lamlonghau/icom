package com.icommerce.product.core.product.usecase;

import com.icommerce.product.core.product.Product;

public interface UpdateProductUseCase {

    Product execute(String id, Product product);
}
