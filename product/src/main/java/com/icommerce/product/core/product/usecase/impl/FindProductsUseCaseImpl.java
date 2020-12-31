package com.icommerce.product.core.product.usecase.impl;

import com.icommerce.product.core.product.Product;
import com.icommerce.product.core.product.port.ProductPersistencePort;
import com.icommerce.product.core.product.usecase.CreateProductUseCase;
import com.icommerce.product.core.product.usecase.FindProductsUseCase;

import java.util.List;

public class FindProductsUseCaseImpl implements FindProductsUseCase {

    private ProductPersistencePort productPersistencePort;

    public FindProductsUseCaseImpl(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }

    @Override
    public List<Product> execute(String search, String sort, Integer size, Integer page) {
        return productPersistencePort.find(search, sort, size, page);
    }
}
