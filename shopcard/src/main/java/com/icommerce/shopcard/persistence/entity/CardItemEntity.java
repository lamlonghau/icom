package com.icommerce.shopcard.persistence.entity;

import java.io.Serializable;

public class CardItemEntity implements Serializable {

    private ProductEntity product;
    private Long quantity;

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
