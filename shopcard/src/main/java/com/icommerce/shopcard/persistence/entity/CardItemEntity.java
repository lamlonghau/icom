package com.icommerce.shopcard.persistence.entity;

import java.io.Serializable;

public class CardItemEntity implements Serializable {

    private ProductEntity productEntity;
    private Long quantity;

    public ProductEntity getProduct() {
        return productEntity;
    }

    public void setProduct(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
