package com.icommerce.shopcard.core.usecase.impl;

import com.icommerce.shopcard.core.ShopCart;
import com.icommerce.shopcard.core.port.ShopCardPort;
import com.icommerce.shopcard.core.usecase.FindShopCardsByCustomerUseCase;

public class FindShopCardsByCustomerUseCaseImpl implements FindShopCardsByCustomerUseCase {

    private ShopCardPort shopCardPort;

    public FindShopCardsByCustomerUseCaseImpl(ShopCardPort shopCardPort) {
        this.shopCardPort = shopCardPort;
    }

    @Override
    public ShopCart execute(String customer) {
        return shopCardPort.findByCustomer(customer);
    }
}
