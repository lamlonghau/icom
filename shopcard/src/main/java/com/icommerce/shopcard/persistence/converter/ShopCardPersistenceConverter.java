package com.icommerce.shopcard.persistence.converter;

import com.icommerce.shopcard.core.shopcard.CardItem;
import com.icommerce.shopcard.core.shopcard.Product;
import com.icommerce.shopcard.core.shopcard.ShopCart;
import com.icommerce.shopcard.persistence.entity.CardItemEntity;
import com.icommerce.shopcard.persistence.entity.ProductEntity;
import com.icommerce.shopcard.persistence.entity.ShopCartEntity;

import java.util.function.Function;
import java.util.stream.Collectors;

public interface ShopCardPersistenceConverter {

    Function<ShopCart, ShopCartEntity> fromModelToEntity = model -> {
        final ShopCartEntity entity = new ShopCartEntity();
        entity.setCustomer(model.getCustomer());
        entity.setItems(model.getItems() == null ? null : model.getItems().stream().map(itm -> {
            final CardItemEntity cardItemEntity = new CardItemEntity();
            cardItemEntity.setQuantity(itm.getQuantity());
            final Product product = itm.getProduct();
            if (product != null) {
                final ProductEntity productEntity = new ProductEntity(
                        product.getId(), product.getName(), product.getCategory(),
                        product.getAttributes(), product.getPrice()
                );
                cardItemEntity.setProduct(productEntity);
            }
            return cardItemEntity;
        }).collect(Collectors.toUnmodifiableList()));
        return entity;
    };

    Function<ShopCartEntity, ShopCart> fromEntityToModel = entity -> {
        final ShopCart model = new ShopCart();
        model.setCustomer(entity.getCustomer());
        model.setItems(entity.getItems() == null ? null : entity.getItems().stream().map(itm -> {
            final CardItem cardItem = new CardItem();
            cardItem.setQuantity(itm.getQuantity());
            final ProductEntity productEntity = itm.getProduct();
            if (productEntity != null) {
                final Product product = new Product(productEntity.getId(),
                        productEntity.getName(),
                        productEntity.getCategory(),
                        productEntity.getAttributes(),
                        productEntity.getPrice());
                cardItem.setProduct(product);
            }
            return cardItem;
        }).collect(Collectors.toUnmodifiableList()));
        return model;
    };
}
