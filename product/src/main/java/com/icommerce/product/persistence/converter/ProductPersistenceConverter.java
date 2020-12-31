package com.icommerce.product.persistence.converter;

import com.icommerce.product.core.product.Product;
import com.icommerce.product.persistence.entity.ProductEntity;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;

public interface ProductPersistenceConverter {

    Function<ProductEntity, Product> fromProductFilterViewEntityToProduct = entity -> {
        final Product product = new Product();
        BeanUtils.copyProperties(entity, product);
        return product;
    };

    Function<Product, ProductEntity> fromProductToProductEntity = product -> {
        final ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(product, entity);
        return entity;
    };
}
