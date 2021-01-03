package com.icommerce.shopcard.persistence.converter;

import com.icommerce.shopcard.core.ShopCart;
import com.icommerce.shopcard.persistence.entity.ShopCartEntity;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;

public interface ShopCardPersistenceConverter {

    Function<ShopCartEntity, ShopCart> fromEntityToModel =
            entity -> {
                final ShopCart model = new ShopCart();
                BeanUtils.copyProperties(entity, model);
                return model;
            };

    Function<ShopCart, ShopCartEntity> fromModelToEntity =
            model -> {
                final ShopCartEntity entity = new ShopCartEntity();
                BeanUtils.copyProperties(model, entity);
                return entity;
            };
}
