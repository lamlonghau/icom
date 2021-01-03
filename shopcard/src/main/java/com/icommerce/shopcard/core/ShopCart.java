package com.icommerce.shopcard.core;

import java.util.List;

public class ShopCart {

    private String customer;
    private List<CardItem> items;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<CardItem> getItems() {
        return items;
    }

    public void setItems(List<CardItem> items) {
        this.items = items;
    }
}
