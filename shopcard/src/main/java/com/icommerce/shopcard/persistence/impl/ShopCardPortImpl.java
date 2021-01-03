package com.icommerce.shopcard.persistence.impl;

import com.icommerce.shopcard.core.ShopCart;
import com.icommerce.shopcard.core.port.ShopCardPort;
import com.icommerce.shopcard.core.shared.ResourceNotFoundException;
import com.icommerce.shopcard.persistence.converter.ShopCardPersistenceConverter;
import com.icommerce.shopcard.persistence.entity.ShopCartEntity;
import com.icommerce.shopcard.persistence.repository.ShopCartRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ShopCardPortImpl implements ShopCardPort {

    @Autowired
    private ShopCartRepository repository;

    @Override
    public List<ShopCart> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(ShopCardPersistenceConverter.fromEntityToModel::apply)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public ShopCart findByCustomer(String customer) {
        final ShopCartEntity entity =
                repository.findById(customer).orElseThrow(ResourceNotFoundException::new);
        return ShopCardPersistenceConverter.fromEntityToModel.apply(entity);
    }

    @Override
    public void delete(String customer) {
        repository.deleteById(customer);
    }

    @Override
    public ShopCart update(String customer, ShopCart shopCart) {
        final ShopCartEntity entity = repository.findById(customer)
                .orElseThrow(ResourceNotFoundException::new);
        BeanUtils.copyProperties(shopCart, entity);
        entity.setCustomer(customer);
        return ShopCardPersistenceConverter.fromEntityToModel.apply(repository.save(entity));
    }

    @Override
    public ShopCart create(ShopCart shopCart) {
        final ShopCartEntity entity = ShopCardPersistenceConverter.fromModelToEntity.apply(shopCart);
        return ShopCardPersistenceConverter.fromEntityToModel.apply(repository.save(entity));
    }
}
