package com.icommerce.shopcard.core.shopcard.port;

import com.icommerce.shopcard.core.shopcard.ShopCart;

import java.util.List;

public interface ShopCardPort {

    List<ShopCart> findAll();
    ShopCart findByCustomer(String customer);
    void delete(String customer);
    ShopCart update(String customer, ShopCart shopCart);
    ShopCart create(ShopCart shopCart);
}
