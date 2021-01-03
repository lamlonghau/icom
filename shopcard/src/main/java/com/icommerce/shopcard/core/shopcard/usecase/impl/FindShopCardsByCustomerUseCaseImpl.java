package com.icommerce.shopcard.core.shopcard.usecase.impl;

import com.icommerce.shopcard.core.shopcard.ShopCart;
import com.icommerce.shopcard.core.shopcard.port.ShopCardPort;
import com.icommerce.shopcard.core.shopcard.usecase.FindShopCardsByCustomerUseCase;

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
