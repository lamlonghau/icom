package com.icommerce.shopcard.core;

import java.util.List;

public class ShopCart {

    private String customer;
    private List<CardItem> cartItems;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<CardItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CardItem> cartItems) {
        this.cartItems = cartItems;
    }
}
