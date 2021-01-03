package com.icommerce.shopcard.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.List;

@RedisHash("shopCart")
public class ShopCartEntity {

    @Id
    @Indexed
    private String customer;
    private List<CardItemEntity> items;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<CardItemEntity> getItems() {
        return items;
    }

    public void setItems(List<CardItemEntity> items) {
        this.items = items;
    }
}
