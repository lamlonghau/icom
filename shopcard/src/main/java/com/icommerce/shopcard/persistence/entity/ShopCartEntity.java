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
    private List<CardItemEntity> cardItemEntities;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<CardItemEntity> getCardItems() {
        return cardItemEntities;
    }

    public void setCardItems(List<CardItemEntity> cardItemEntities) {
        this.cardItemEntities = cardItemEntities;
    }
}
