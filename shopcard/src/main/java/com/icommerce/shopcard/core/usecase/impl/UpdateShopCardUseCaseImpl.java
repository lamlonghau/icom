package com.icommerce.shopcard.core.usecase.impl;

import com.icommerce.shopcard.core.ShopCart;
import com.icommerce.shopcard.core.port.ShopCardPort;
import com.icommerce.shopcard.core.usecase.UpdateShopCardUseCase;

public class UpdateShopCardUseCaseImpl implements UpdateShopCardUseCase {

    private ShopCardPort shopCardPort;

    public UpdateShopCardUseCaseImpl(ShopCardPort shopCardPort) {
        this.shopCardPort = shopCardPort;
    }

    @Override
    public ShopCart execute(String customer, ShopCart shopCart) {
        return shopCardPort.update(customer, shopCart);
    }

}
