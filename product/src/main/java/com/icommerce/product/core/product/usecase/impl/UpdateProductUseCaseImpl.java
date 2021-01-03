package com.icommerce.product.core.product.usecase.impl;

import com.icommerce.product.core.product.Product;
import com.icommerce.product.core.product.port.ProductPersistencePort;
import com.icommerce.product.core.product.usecase.CreateProductUseCase;
import com.icommerce.product.core.product.usecase.UpdateProductUseCase;
import com.icommerce.product.core.shared.UpdatingValidationGroup;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private ProductPersistencePort productPersistencePort;

    public UpdateProductUseCaseImpl(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }

    @Override
    public Product execute(String id, Product product) {
        product.setId(id);
        product.validateSelf(UpdatingValidationGroup.class);
        return productPersistencePort.update(id, product);
    }
}
