package com.icommerce.product.persistence.impl;

import com.icommerce.product.core.product.Product;
import com.icommerce.product.core.product.port.ProductPersistencePort;
import com.icommerce.product.persistence.converter.ProductPersistenceConverter;
import com.icommerce.product.persistence.entity.ProductEntity;
import com.icommerce.product.persistence.repository.ProductRepository;
import com.icommerce.product.persistence.shared.GenericSpecificationsBuilder;
import com.icommerce.product.persistence.shared.PageableBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductPersistencePortImpl implements ProductPersistencePort {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> find(String search, String sort, Integer size, Integer page) {
        final Specification<ProductEntity> specs = GenericSpecificationsBuilder.build(search);
        final Pageable pageable = PageableBuilder.build(sort, size, page);
        final Page<ProductEntity> resp = repository.findAll(specs, pageable);
        final Set<ProductEntity> filters = new HashSet<>(resp.getContent());
        return filters.stream().map(ProductPersistenceConverter.fromProductFilterViewEntityToProduct)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String create(Product product) {
        final ProductEntity entity = ProductPersistenceConverter.fromProductToProductEntity.apply(product);
        return repository.save(entity).getId();
    }
}
