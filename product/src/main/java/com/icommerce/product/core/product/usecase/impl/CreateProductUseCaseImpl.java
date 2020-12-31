package com.icommerce.product.core.product.usecase.impl;

import com.icommerce.product.core.product.Product;
import com.icommerce.product.core.product.port.ProductPersistencePort;
import com.icommerce.product.core.product.usecase.CreateProductUseCase;

public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private ProductPersistencePort productPersistencePort;

    public CreateProductUseCaseImpl(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }

    @Override
    public String execute(Product product) {
        product.validateSelf();
        return productPersistencePort.create(product);
    }
}
