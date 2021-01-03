package com.icommerce.shopcard.core.usecase.impl;

import com.icommerce.shopcard.core.ShopCart;
import com.icommerce.shopcard.core.port.ShopCardPort;
import com.icommerce.shopcard.core.usecase.CreateShopCardUseCase;

public class CreateShopCardUseCaseImpl implements CreateShopCardUseCase {

    private ShopCardPort shopCardPort;

    public CreateShopCardUseCaseImpl(ShopCardPort shopCardPort) {
        this.shopCardPort = shopCardPort;
    }

    @Override
    public ShopCart execute(ShopCart shopCart) {
        return shopCardPort.create(shopCart);
    }
}
